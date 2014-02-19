package net.sf.anathema.character.raksha.lure;


import net.sf.anathema.character.generic.additionaltemplate.IAdditionalModel;
import net.sf.anathema.character.generic.framework.additionaltemplate.IAdditionalViewFactory;
import net.sf.anathema.character.generic.type.ICharacterType;
import net.sf.anathema.character.raksha.lure.model.IRakshaLureModel;
import net.sf.anathema.character.raksha.lure.presenter.RakshaLurePresenter;
import net.sf.anathema.character.raksha.lure.view.RakshaLureView;
import net.sf.anathema.character.library.intvalue.IntValueDisplayFactoryPrototype;
import net.sf.anathema.framework.swing.IView;
import net.sf.anathema.lib.resources.Resources;


public class IRakshaLureViewFactory implements IAdditionalViewFactory {


  @Override
  public IView createView(IAdditionalModel model, Resources resources, ICharacterType type) {
    RakshaLureView view = new RakshaLureView(
            IntValueDisplayFactoryPrototype.createWithMarkerForCharacterType(type));
    new RakshaLurePresenter(resources, view, (IRakshaLureModel) model).initPresentation();
    return view;
  }
}

