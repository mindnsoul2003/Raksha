package net.sf.anathema.character.raksha.lure.persistence;

import net.sf.anathema.character.raksha.lure.model.RakshaLure;
import net.sf.anathema.character.library.virtueflaw.model.IVirtueFlaw;
import net.sf.anathema.character.library.virtueflaw.persistence.VirtueFlawPersister;
import net.sf.anathema.framework.persistence.TextPersister;
import net.sf.anathema.lib.exception.PersistenceException;
import org.dom4j.Element;

public class RakshaLurePersister extends VirtueFlawPersister {

  public static final String TAG_DESCRIPTION = "description";
  private final TextPersister textPersister = new TextPersister();

  @Override
  protected void saveVirtueFlaw(Element flawElement, IVirtueFlaw virtueFlaw) {
    super.saveVirtueFlaw(flawElement, virtueFlaw);
    RakshaLure rakshaLure = (RakshaLure) virtueFlaw;
    textPersister.saveTextualDescription(flawElement, TAG_DESCRIPTION, rakshaLure.getDescription());
  }

  @Override
  protected void loadVirtueFlaw(Element flawElement, IVirtueFlaw virtueFlaw) {
    try {
      super.loadVirtueFlaw(flawElement, virtueFlaw);
      RakshaLure rakshaLure = (RakshaLure) virtueFlaw;
      textPersister.restoreTextualDescription(flawElement, TAG_DESCRIPTION, rakshaLure.getDescription());
    } catch (PersistenceException e) {
      e.printStackTrace();
    }
  }
}

