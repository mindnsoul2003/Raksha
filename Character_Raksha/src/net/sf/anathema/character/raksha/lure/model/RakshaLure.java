package net.sf.anathema.character.raksha.lure.model;


import net.sf.anathema.character.generic.framework.additionaltemplate.model.ICharacterModelContext;
import net.sf.anathema.character.library.virtueflaw.model.VirtueFlaw;
import net.sf.anathema.lib.workflow.textualdescription.ITextualDescription;
import net.sf.anathema.lib.workflow.textualdescription.model.SimpleTextualDescription;


public class RakshaLure extends VirtueFlaw {
  private final ITextualDescription description = new SimpleTextualDescription("");


  public RakshaLure(ICharacterModelContext context) {
    super(context);
  }


  public ITextualDescription getDescription() {
    return description;
  }
}

