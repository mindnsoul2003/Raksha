package net.sf.anathema.character.reporting.pdf.content.stats;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;
import net.sf.anathema.character.generic.util.IStats;
import net.sf.anathema.lib.resources.IResources;

public abstract class AbstractNameStatsGroup<T extends IStats> extends AbstractTextStatsGroup<T> {
  private final String title;
  private final IResources resources;

  public AbstractNameStatsGroup(IResources resources) {
    this.resources = resources;
    this.title = resources.getString(getHeaderResourceKey());
  }

  @Override
  public final String getTitle() {
    return title;
  }

  @Override
  public Float[] getColumnWeights() {
    return new Float[]{6f};
  }

  @Override
  public void addContent(PdfPTable table, Font font, T stats) {
    if (stats == null) {
      table.addCell(createTextCell(font, "")); //$NON-NLS-1$
    } else {
      String resourceKey = getResourceBase() + stats.getName().getId();
      table.addCell(createTextCell(font, resources.getString(resourceKey)));
    }
  }

  protected abstract String getHeaderResourceKey();

  protected abstract String getResourceBase();
}
