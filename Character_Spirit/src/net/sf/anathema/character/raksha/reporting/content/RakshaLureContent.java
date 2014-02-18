package net.sf.anathema.character.raksha.reporting.content;


import net.sf.anathema.character.generic.character.IGenericCharacter;
import net.sf.anathema.character.raksha.lure.RakshaLureTemplate;
import net.sf.anathema.character.raksha.lure.model.IInfernalUrgeModel;
import net.sf.anathema.character.reporting.pdf.content.AbstractSubBoxContent;
import net.sf.anathema.lib.resources.Resources;


import static java.text.MessageFormat.format;


public class RakshaLureContent extends AbstractSubBoxContent {


  private IGenericCharacter character;


  public RakshaLureContent(Resources resources, IGenericCharacter character) {
    super(resources);
    this.character = character;
  }


  @Override
  public String getHeaderKey() {
    return "RakshaLure.Title";
  }


  public int getLimitValue() {
    return getLureModel().getVirtueFlaw().getLimitTrait().getCurrentValue();
  }


  public String getLureDescription() {
    return getLureModel().getDescription().getText();
  }


  private IRakshaLureModel getLureModel() {
    return ((IRakshaLureModel) character.getAdditionalModel(RakshaLureTemplate.ID));
  }


  public String getLureTitle() {
    return format("{0}: ", getString("RakshaLure.Title"));
  }
}

