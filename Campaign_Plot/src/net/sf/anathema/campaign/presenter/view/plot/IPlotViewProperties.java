package net.sf.anathema.campaign.presenter.view.plot;

import net.sf.anathema.lib.gui.action.SmartAction;

public interface IPlotViewProperties {

  void initHierarchyRemoveAction(SmartAction action);

  void initHierarchyAddAction(SmartAction action);

  void initHierarchyUpAction(SmartAction action);

  void initHierarchyDownAction(SmartAction action);

  String getBorderTitle();
}