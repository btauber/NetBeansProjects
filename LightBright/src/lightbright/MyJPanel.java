package lightbright;

import java.awt.Graphics;
import javax.swing.JPanel;

public class MyJPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        
    }
}
