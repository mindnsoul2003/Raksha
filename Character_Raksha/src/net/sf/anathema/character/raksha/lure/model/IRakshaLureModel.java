package net.sf.anathema.character.raksha.lure.model;


import net.sf.anathema.character.library.virtueflaw.presenter.IVirtueFlawModel;
import net.sf.anathema.lib.workflow.textualdescription.ITextualDescription;


public interface IRakshaLureModel extends IVirtueFlawModel {
  ITextualDescription getDescription();


  void setDescription(String lure);
}

