package net.sf.anathema.character.impl.view.magic;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import net.sf.anathema.charmtree.AbstractCascadeSelectionView;
import net.sf.anathema.charmtree.presenter.view.ICharmView;
import net.sf.anathema.framework.value.IIntValueView;
import net.sf.anathema.framework.value.IntegerViewFactory;
import net.sf.anathema.lib.workflow.booleanvalue.IBooleanValueView;
import net.sf.anathema.platform.tree.presenter.view.ISpecialNodeView;
import net.sf.anathema.platform.tree.presenter.view.NodeInteractionListener;
import net.sf.anathema.platform.tree.presenter.view.NodeProperties;
import net.sf.anathema.platform.tree.presenter.view.ToolTipProperties;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Color;

public class CharmView extends AbstractCascadeSelectionView implements ICharmView {
  private final JPanel content = new JPanel(new MigLayout(new LC().wrapAfter(1).fill()));

  public CharmView(ToolTipProperties treeProperties, NodeProperties nodeProperties,
                   IntegerViewFactory integerDisplayFactory) {
    super(treeProperties, nodeProperties);
    getCharmTreeView().registerSpecialType(IIntValueView.class, new SpecialIntDisplayFactory(integerDisplayFactory));
    getCharmTreeView().registerSpecialType(IBooleanValueView.class, new SpecialBooleanDisplayFactory());
  }

  @Override
  public void initGui() {
    content.add(getSelectionComponent(), new CC().growX());
    content.add(getCharmComponent(), new CC().grow().push());
  }

  @Override
  public void addCharmInteractionListener(NodeInteractionListener listener) {
    getCharmTreeView().addNodeInteractionListener(listener);
  }

  @Override
  public void setCharmVisuals(String charmId, Color fillColor, int opacity) {
    getCharmTreeView().setNodeBackgroundColor(charmId, fillColor);
    getCharmTreeView().setNodeAlpha(charmId, opacity);
  }

  @Override
  public JComponent getComponent() {
    return content;
  }

  @Override
  public void setSpecialCharmViewVisible(ISpecialNodeView charmView, boolean visible) {
    if (visible) {
      getCharmTreeView().addSpecialControl(charmView.getNodeId(), charmView);
    }
  }

  @Override
  public void hideSpecialCharmViews() {
    //TODO: Implement
  }
}