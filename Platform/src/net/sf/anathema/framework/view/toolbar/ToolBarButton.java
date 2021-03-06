package net.sf.anathema.framework.view.toolbar;

import net.sf.anathema.framework.value.NoFocusButton;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

public class ToolBarButton extends NoFocusButton {

  @Override
  public void setAction(Action action) {
    super.setAction(action);
    configureActionIcons(action);
  }

  private void configureActionIcons(Action action) {
    Icon icon = (Icon) action.getValue(Action.SMALL_ICON);
    if (!(icon instanceof ImageIcon)) {
      return;
    }
    ImageIcon rolloverIcon = (ImageIcon) icon;
    int width = rolloverIcon.getIconWidth();
    int height = rolloverIcon.getIconHeight();

    Image image = new BufferedImage(width, height, Transparency.TRANSLUCENT);
    Graphics2D graphics = (Graphics2D) image.getGraphics();
    Composite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .8f);
    graphics.setComposite(alpha);
    graphics.drawImage(rolloverIcon.getImage(), 0, 0, null);
    graphics.dispose();
    ImageIcon defaultIcon = new ImageIcon(image);

    setIcon(defaultIcon);
    setRolloverIcon(rolloverIcon);
    setPressedIcon(rolloverIcon);
  }
}