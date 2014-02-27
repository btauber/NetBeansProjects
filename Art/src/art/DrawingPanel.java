package art;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DrawingPanel extends JPanel {
    private ArrayList<ArrayList<Point>> allPoints = new ArrayList<ArrayList<Point>>();
    private ArrayList<Point> points;
    private ArrayList<Color> allColor = new ArrayList<Color>();
    private ArrayList<Integer> allSize = new ArrayList<Integer>();
    Color color;
    int size;
    public DrawingPanel() {
         MouseAdapter mouseListener = new MouseAdapter() { 
            public void mousePressed(MouseEvent e) {
                
                System.out.println("pressed");
                points = new ArrayList<Point>();
                allPoints.add(points);
                
                points.add(new Point(e.getX(), e.getY()));
                allColor.add(color);
                allSize.add(size);
                repaint();
            }
            public void mouseDragged(MouseEvent e) {
                System.out.println("dragged");
                points.add(new Point(e.getX(), e.getY()));
                repaint();
            }
            public void mouseReleased(MouseEvent e) {
                
                System.out.println("released");
                
            }
        };

        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
    }
    
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        
        
        for(ArrayList<Point> points : allPoints) {
            Point last = null;
            for(Point point : points) {
                if (last != null) {
                    g2.setStroke(new BasicStroke(9));
                    g2.setColor(Color.red);
                    g2.drawLine(last.x, last.y, point.x, point.y);
                    
                }
                last = point;
            } 
        }
    }
}
