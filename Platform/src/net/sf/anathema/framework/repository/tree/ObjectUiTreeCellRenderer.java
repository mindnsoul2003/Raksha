package net.sf.anathema.framework.repository.tree;

import net.sf.anathema.lib.gui.icon.DisabledIconDecorator;
import net.sf.anathema.lib.gui.ui.IObjectUi;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.Component;

public class ObjectUiTreeCellRenderer extends DefaultTreeCellRenderer {

  private final IObjectUi<Object> ui;

  public ObjectUiTreeCellRenderer(IObjectUi<Object> ui) {
    this.ui = ui;
  }

  @Override
  public Component getTreeCellRendererComponent(
      JTree tree,
      Object value,
      boolean sel,
      boolean expanded,
      boolean leaf,
      int row,
      boolean focus) {
    super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, focus);
    Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
    Icon icon = ui.getIcon(userObject);
    if (icon != null && !tree.isEnabled()) {
      icon = new DisabledIconDecorator(icon);
    }
    setIcon(icon);
    setDisabledIcon(icon == null ? null : new DisabledIconDecorator(icon));
    setText(ui.getLabel(userObject));
    return this;
  }
}