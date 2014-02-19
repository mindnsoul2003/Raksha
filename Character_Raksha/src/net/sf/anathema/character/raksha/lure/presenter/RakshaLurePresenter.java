package net.sf.anathema.character.raksha.lure.presenter;


import net.sf.anathema.character.raksha.lure.model.IRakshaLureModel;
import net.sf.anathema.character.raksha.lure.model.RakshalLure;
import net.sf.anathema.character.raksha.lure.view.IRakshaLureView;
import net.sf.anathema.character.library.virtueflaw.model.IVirtueFlaw;
import net.sf.anathema.character.library.virtueflaw.presenter.VirtueFlawPresenter;
import net.sf.anathema.lib.resources.Resources;
import net.sf.anathema.lib.workflow.textualdescription.ITextView;
import net.sf.anathema.lib.workflow.textualdescription.TextualPresentation;


public class RakshaLurePresenter extends VirtueFlawPresenter {
  private final IRakshaLureView view;
  private final IRakshaLureModel model;


  public RakshaLurePresenter(Resources resources, IRakshaLureView lureView, IRakshaLureModel model) {
    super(resources, urgeView, model);
    this.view = lureView;
    this.model = model;
  }


  @Override
  protected void initBasicPresentation() {
    IVirtueFlaw virtueFlaw = model.getVirtueFlaw();
    initRootPresentation(virtueFlaw, "Torment.FlawedVirtue.Name");
  }


  @Override
  protected void initAdditionalPresentation() {
    RakshaLure virtueFlaw = (RakshaLure) model.getVirtueFlaw();
    TextualPresentation presentation = new TextualPresentation();
    initDescriptionPresentation(virtueFlaw, presentation);
  }


  private void initDescriptionPresentation(RakshaLure virtueFlaw, TextualPresentation textualPresentation) {
    ITextView descriptionView = view.addTextView(getResources().getString("VirtueFlaw.Description.Name"), 30,
            3);
    textualPresentation.initView(descriptionView, virtueFlaw.getDescription());
  }
}

