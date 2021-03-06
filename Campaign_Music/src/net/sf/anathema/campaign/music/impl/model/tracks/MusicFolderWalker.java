package net.sf.anathema.campaign.music.impl.model.tracks;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import net.sf.anathema.campaign.music.model.libary.IMusicFolderWalker;
import net.sf.anathema.campaign.music.model.libary.ITrackHandler;
import net.sf.anathema.campaign.music.model.track.IMp3Track;
import net.sf.anathema.lib.io.PathUtils;
import net.sf.anathema.lib.logging.Logger;
import net.sf.anathema.lib.progress.Cancelable;
import net.sf.anathema.lib.progress.IProgressMonitor;
import net.sf.anathema.lib.resources.IResources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MusicFolderWalker implements IMusicFolderWalker {
  private static final Logger logger = Logger.getLogger(MusicFolderWalker.class);
  private final Path musicFolder;

  public MusicFolderWalker(Path musicFolder) throws IOException {
    Preconditions.checkNotNull(musicFolder);
    if (!Files.exists(musicFolder)) {
      throw new IOException("LibraryFile does not exist." + musicFolder); //$NON-NLS-1$
    }
    this.musicFolder = musicFolder;
  }

  public static boolean isMp3File(Path file) {
    return !Files.isDirectory(file) && file.toString().endsWith(".mp3"); //$NON-NLS-1$
  }

  @Override
  public void walk(IResources resources, IProgressMonitor monitor, Cancelable cancelFlag,
                   ITrackHandler handler) throws InterruptedException {
    monitor.beginTaskWithUnknownTotalWork(resources.getString(
            "Music.Actions.AddFolder.ProgressMonitor.Preprocessing") + " '" + musicFolder + "'."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    int trackCount = getTrackCount();
    monitor.beginTask(resources.getString(
            "Music.Actions.AddFolder.ProgressMonitor.Loading") + " '" + musicFolder + "' (" + trackCount + " " + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            resources.getString("Music.Actions.AddFolder.ProgressMonitor.Tracks") + //$NON-NLS-1$
            ").", //$NON-NLS-1$
            trackCount);
    walkFile(monitor, cancelFlag, Paths.get("."), handler);
  }

  private int getTrackCount() {
    return PathUtils.getRecursiveFileCount(musicFolder, new Predicate<Path>() {
      @Override
      public boolean apply(Path file) {
        return isMp3File(file);
      }
    });
  }

  private void walkDirectory(IProgressMonitor monitor, Cancelable cancelFlag, Path relativePath,
                             ITrackHandler handler) throws InterruptedException {
    Path file = musicFolder.resolve(relativePath);
    for (Path child : PathUtils.listAll(file)) {
      Path childRelativePath = relativePath.resolve(child);
      walkFile(monitor, cancelFlag, childRelativePath, handler);
    }
  }

  private void walkFile(IProgressMonitor monitor, Cancelable cancelFlag, Path relativePath,
                        ITrackHandler handler) throws InterruptedException {
    Path file = musicFolder.resolve(relativePath);
    if (Files.isDirectory(file)) {
      walkDirectory(monitor, cancelFlag, relativePath, handler);
    }
    if (isMp3File(file)) {
      try {
        IMp3Track mp3Item = new FileMp3Track(file);
        handler.handleMp3(mp3Item);
      } catch (Exception e) {
        logger.warn("Could not handle mp3-file: " + file.toString());
      }
      if (cancelFlag.isCanceled()) {
        throw new InterruptedException();
      }
      monitor.worked(1);
    }
  }
}