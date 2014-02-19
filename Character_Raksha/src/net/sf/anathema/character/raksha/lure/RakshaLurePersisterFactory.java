package net.sf.anathema.character.raksha.lure;


import net.sf.anathema.character.generic.framework.additionaltemplate.persistence.IAdditionalPersister;
import net.sf.anathema.character.generic.framework.additionaltemplate.persistence.IAdditionalPersisterFactory;
import net.sf.anathema.character.raksha.lure.persistence.RakshaLurePersister;
import net.sf.anathema.framework.messaging.IMessaging;


public class RakshaLurePersisterFactory implements IAdditionalPersisterFactory {


  @Override
  public IAdditionalPersister createPersister(IMessaging messaging) {
    return new RakshaLurePersister();
  }
}

