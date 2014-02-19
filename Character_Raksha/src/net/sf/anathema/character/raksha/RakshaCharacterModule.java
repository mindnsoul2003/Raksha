package net.sf.anathema.character.raksha;

import net.sf.anathema.character.generic.backgrounds.IBackgroundTemplate;
import net.sf.anathema.character.generic.framework.ICharacterGenerics;
import net.sf.anathema.character.generic.framework.additionaltemplate.IAdditionalViewFactory;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.IAdditionalModelFactory;
import net.sf.anathema.character.generic.framework.additionaltemplate.persistence.IAdditionalPersisterFactory;
import net.sf.anathema.character.generic.framework.module.CharacterModule;
import net.sf.anathema.character.generic.framework.module.CharacterTypeModule;
import net.sf.anathema.character.generic.impl.backgrounds.CharacterTypeBackgroundTemplate;
import net.sf.anathema.character.generic.impl.caste.CasteCollection;
import net.sf.anathema.character.generic.type.ICharacterType;
import net.sf.anathema.character.raksha.caste.RakshaCaste;
import net.sf.anathema.character.raksha.lure.RakshaLurePersisterFactory;
import net.sf.anathema.character.raksha.lure.RakshaLureTemplate;
import net.sf.anathema.character.raksha.lure.RakshaLureViewFactory;
import net.sf.anathema.lib.registry.IIdentificateRegistry;
import net.sf.anathema.lib.registry.IRegistry;


@CharacterModule
public class RakshaCharacterModule extends CharacterTypeModule {
  public static final ICharacterType type = new RakshaCharacterType();


  @Override
  public void registerCommonData(ICharacterGenerics characterGenerics) {
    characterGenerics.getCasteCollectionRegistry().register(type, new CasteCollection(RakshaCaste.values()));
  }

  @Override
  public void addAdditionalTemplateData(ICharacterGenerics characterGenerics) {
    IRegistry<String, IAdditionalModelFactory> additionalModelFactoryRegistry = characterGenerics.getAdditionalModelFactoryRegistry();
    IRegistry<String, IAdditionalViewFactory> additionalViewFactoryRegistry = characterGenerics.getAdditionalViewFactoryRegistry();
    IRegistry<String, IAdditionalPersisterFactory> persisterFactory = characterGenerics.getAdditonalPersisterFactoryRegistry();
    registerRakshaLure(additionalModelFactoryRegistry, additionalViewFactoryRegistry, persisterFactory);
  }

  private void registerRakshaLure(IRegistry<String, IAdditionalModelFactory> additionalModelFactoryRegistry,
                                    IRegistry<String, IAdditionalViewFactory> additionalViewFactoryRegistry, IRegistry<String, IAdditionalPersisterFactory> persisterFactory) {
    String templateId = RakshaLureTemplate.ID;
    additionalModelFactoryRegistry.register(templateId, new RakshaLureModelFactory());
    additionalViewFactoryRegistry.register(templateId, new RakshaLureViewFactory());
    persisterFactory.register(templateId, new RakshaLurePersisterFactory());
  }
    @Override
  protected ICharacterType getType() {
    return type;
  }
}
