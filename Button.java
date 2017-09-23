import javax.swing.JButton;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;
public class Button extends JButton{
    public Button(String _text, int x_pos,int y_pos) {
	this.setText(_text);
	this.setHorizontalTextPosition(x_pos);
	this.setVerticalTextPosition(y_pos);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusable(false);

    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (getModel().isPressed()) {
            g.setColor(g.getColor());
            g2.fillRect(3, 3, getWidth() - 6, getHeight() - 6);
        }
        super.paintComponent(g);
            g2.setColor(new Color(252, 195, 86));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1.2f));
        g2.draw(new RoundRectangle2D.Double(1, 1, (getWidth() - 3),
                (getHeight() - 3), 12, 8));
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawLine(4, getHeight() - 3, getWidth() - 4, getHeight() - 3);
        g2.dispose();
    }
}
