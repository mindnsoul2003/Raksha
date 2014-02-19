package net.sf.anathema.character.raksha.lure;


import net.sf.anathema.character.generic.additionaltemplate.IAdditionalModel;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.IAdditionalModelFactory;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.ICharacterModelContext;
import net.sf.anathema.character.generic.template.additional.IAdditionalTemplate;
import net.sf.anathema.character.raksha.lure.model.RakshaLureModel;


public class RakshaLureModelFactory implements IAdditionalModelFactory {


  @Override
  public IAdditionalModel createModel(IAdditionalTemplate additionalTemplate, ICharacterModelContext context) {
	  return new RakshaLureModel((RakshaLureTemplate) additionalTemplate, context);
  }
}

