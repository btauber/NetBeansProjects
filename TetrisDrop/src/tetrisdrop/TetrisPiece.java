package tetrisdrop;

import java.awt.*;
import javax.swing.*;

public abstract class TetrisPiece extends JComponent {
    protected Point[] points = new Point[4];
    protected Color color;
    
    public static final int SEGMENT_SIZE = 40;
    public static final int STROKE_THICKNESS = 3;
    
    public TetrisPiece() {
        setSize(4 * SEGMENT_SIZE + STROKE_THICKNESS, 4 * SEGMENT_SIZE + STROKE_THICKNESS);
        
    }
    
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(STROKE_THICKNESS));
        for(Point p : points){
            g2.setColor(Color.BLACK);
            g2.draw3DRect(p.x, p.y, SEGMENT_SIZE, SEGMENT_SIZE, true);
            g2.setColor(color);
            g2.fill3DRect(p.x + 1, p.y + 1, SEGMENT_SIZE - 1, SEGMENT_SIZE - 1, true);
            
        }
    }
}
