import javax.swing.*;
import java.awt.*;

public class CustomButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton button = (AbstractButton) c;
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (button.getModel().isPressed()) {
            g2d.setColor(Color.LIGHT_GRAY);
        } else if (button.getModel().isRollover()) {
            g2d.setColor(new Color(200, 230, 255));
        } else {
            g2d.setColor(button.getBackground());
        }
        g2d.fillRoundRect(0, 0, button.getWidth(), button.getHeight(), 15, 15);

        g2d.setColor(button.getForeground());
        FontMetrics fm = g2d.getFontMetrics();
        int stringWidth = fm.stringWidth(button.getText());
        int stringHeight = fm.getAscent();
        g2d.drawString(button.getText(),
                (button.getWidth() - stringWidth) / 2,
                (button.getHeight() + stringHeight) / 2 - 2);
        g2d.dispose();
    }
}
