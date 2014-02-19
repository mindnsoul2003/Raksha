package net.sf.anathema.character.raksha.lure.model;

import net.sf.anathema.character.generic.additionaltemplate.AdditionalModelType;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.ICharacterModelContext;
import net.sf.anathema.character.generic.traits.ITraitType;
import net.sf.anathema.character.generic.traits.types.VirtueType;
import net.sf.anathema.character.raksha.lure.RakshaLureTemplate;
import net.sf.anathema.character.library.virtueflaw.model.IVirtueFlaw;
import net.sf.anathema.character.library.virtueflaw.model.VirtueFlawModel;
import net.sf.anathema.lib.control.GlobalChangeAdapter;
import net.sf.anathema.lib.control.IChangeListener;
import net.sf.anathema.lib.workflow.textualdescription.ITextualDescription;

import java.util.ArrayList;
import java.util.List;

public class RakshaLureModel extends VirtueFlawModel implements IRakshaLureModel {
  private RakshaLure rakshaLure;
  private RakshaLureTemplate template;

  public RakshaLureModel(RakshaLureTemplate template, ICharacterModelContext context) {
    super(context, template);
    this.template = template;
    rakshaLure = new RakshaLure(context);
  }

  @Override
  public IVirtueFlaw getVirtueFlaw() {
    return rakshaLure;
  }

  @Override
  public ITraitType[] getFlawVirtueTypes() {
    List<ITraitType> flawVirtues = new ArrayList<>();
    for (VirtueType virtueType : VirtueType.values()) {
      if (getContext().getTraitCollection().getTrait(virtueType).getCurrentValue() > 2) {
        flawVirtues.add(virtueType);
      }
    }
    return flawVirtues.toArray(new ITraitType[flawVirtues.size()]);
  }

  @Override
  public AdditionalModelType getAdditionalModelType() {
    return AdditionalModelType.Advantages;
  }

  @Override
  public String getTemplateId() {
    return template.getId();
  }

  @Override
  public void addChangeListener(IChangeListener listener) {
    super.addChangeListener(listener);
    getDescription().addTextChangedListener(new GlobalChangeAdapter<String>(listener));
  }

  @Override
  public ITextualDescription getDescription() {
    return infernalUrge.getDescription();
  }

  @Override
  public void setDescription(String urge) {
    getDescription().setText(urge);
  }
}

