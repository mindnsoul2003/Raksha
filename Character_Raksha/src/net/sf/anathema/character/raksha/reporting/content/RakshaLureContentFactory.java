package net.sf.anathema.character.raksha.reporting.content;

import net.sf.anathema.character.generic.character.IGenericCharacter;
import net.sf.anathema.character.reporting.pdf.content.RegisteredReportContent;
import net.sf.anathema.character.reporting.pdf.content.ReportContentFactory;
import net.sf.anathema.character.reporting.pdf.content.ReportSession;
import net.sf.anathema.lib.resources.Resources;

@RegisteredReportContent(produces = RakshaLureContent.class)
public class RakshaLureFactory implements ReportContentFactory<RakshaLureContent> {
  private Resources resources;

  public RakshaLureFactory(Resources resources) {
    this.resources = resources;
  }

  @Override
  public RakshaLureContent create(ReportSession session, IGenericCharacter character) {
    return new RakshaLureContent(resources, character);
  }
}

