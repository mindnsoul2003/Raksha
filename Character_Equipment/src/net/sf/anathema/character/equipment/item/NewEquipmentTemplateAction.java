package net.sf.anathema.character.equipment.item;

import net.sf.anathema.character.equipment.item.model.IEquipmentDatabaseManagement;
import net.sf.anathema.framework.presenter.resources.PlatformUI;
import net.sf.anathema.lib.gui.action.SmartAction;
import net.sf.anathema.lib.gui.wizard.workflow.ICondition;
import net.sf.anathema.lib.resources.IResources;

import java.awt.Component;

public final class NewEquipmentTemplateAction extends SmartAction {
  private final IEquipmentDatabaseManagement model;
  private final IResources resources;

  public NewEquipmentTemplateAction(IResources resources, IEquipmentDatabaseManagement model) {
    super(new PlatformUI(resources).getNewIcon());
    this.resources = resources;
    this.model = model;
    setToolTipText(resources.getString("Equipment.Creation.Item.NewActionTooltip")); //$NON-NLS-1$
  }

  @Override
  protected void execute(Component parentComponent) {
    DiscardChangesVetor vetor = new DiscardChangesVetor(resources, new ICondition() {
      @Override
      public boolean isFulfilled() {
        return model.getTemplateEditModel().isDirty();
      }
    }, parentComponent);
    if (vetor.vetos()) {
      return;
    }
    model.getTemplateEditModel().setNewTemplate();
  }
}