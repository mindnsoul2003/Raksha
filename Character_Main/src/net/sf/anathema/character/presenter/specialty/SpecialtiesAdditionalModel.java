package net.sf.anathema.character.presenter.specialty;

import net.sf.anathema.character.generic.additionaltemplate.AdditionalModelType;
import net.sf.anathema.character.generic.additionaltemplate.IAdditionalModelBonusPointCalculator;
import net.sf.anathema.character.generic.additionaltemplate.IAdditionalModelExperienceCalculator;
import net.sf.anathema.character.generic.additionaltemplate.NullAdditionalModelBonusPointCalculator;
import net.sf.anathema.character.generic.additionaltemplate.NullAdditionalModelExperienceCalculator;
import net.sf.anathema.character.generic.character.IGenericTraitCollection;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.ICharacterModelContext;
import net.sf.anathema.character.generic.template.additional.IAdditionalTemplate;
import net.sf.anathema.character.library.trait.specialties.ISpecialtiesConfiguration;
import net.sf.anathema.character.model.traits.ICoreTraitConfiguration;
import net.sf.anathema.lib.control.change.IChangeListener;

public class SpecialtiesAdditionalModel implements ISpecialtiesAdditionalModel {

  private final IAdditionalTemplate additionalTemplate;
  private final ISpecialtiesConfiguration model;

  public SpecialtiesAdditionalModel(IAdditionalTemplate additionalTemplate, ICharacterModelContext context) {
    this.additionalTemplate = additionalTemplate;
    IGenericTraitCollection traitCollection = context.getTraitCollection();
    this.model = ((ICoreTraitConfiguration) traitCollection).getSpecialtyConfiguration();
  }

  public void addBonusPointsChangeListener(IChangeListener listener) {
    // nothing to do
  }

  public AdditionalModelType getAdditionalModelType() {
    return AdditionalModelType.Abilities;
  }

  public IAdditionalModelBonusPointCalculator getBonusPointCalculator() {
    return new NullAdditionalModelBonusPointCalculator();
  }

  public IAdditionalModelExperienceCalculator getExperienceCalculator() {
    return new NullAdditionalModelExperienceCalculator();
  }

  public String getTemplateId() {
    return additionalTemplate.getId();
  }

  public ISpecialtiesConfiguration getSpecialtiesModel() {
    return model;
  }
}