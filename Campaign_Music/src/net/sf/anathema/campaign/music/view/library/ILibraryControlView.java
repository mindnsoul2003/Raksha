package net.sf.anathema.campaign.music.view.library;

import net.sf.anathema.campaign.music.model.libary.ILibrary;
import net.sf.anathema.campaign.music.model.track.IMp3Track;
import net.sf.anathema.campaign.music.view.categorization.IMusicCategorizationView;
import net.sf.anathema.campaign.music.view.search.ISearchComponent;
import net.sf.anathema.lib.gui.list.actionview.IActionAddableListView;
import net.sf.anathema.lib.gui.list.actionview.NamedActionAddableListView;

public interface ILibraryControlView extends LibraryListView {

  ISearchComponent addSearchParameter(String string);

  IActionAddableListView<ILibrary> getLibraryView();

  IMusicCategorizationView getSearchMusicCategorizationView();

  NamedActionAddableListView<IMp3Track> getTrackListView();

  void initGui();

  void whenSearchIsTriggered(Runnable action);
}