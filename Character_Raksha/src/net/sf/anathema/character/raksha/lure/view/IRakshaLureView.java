package net.sf.anathema.character.raksha.lure.view;


import net.sf.anathema.character.library.virtueflaw.presenter.IVirtueFlawView;
import net.sf.anathema.lib.workflow.textualdescription.ITextView;


public interface IRakshaLureView extends IVirtueFlawView {


  ITextView addTextView(String label, int columnCount, int rows);
}

