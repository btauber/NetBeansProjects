package artstudio;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DrawingPanel extends JPanel {

    private ArrayList<DrawingPanel> allPanels = new ArrayList<>();
    private ArrayList<ArrayList<Point>> allPoints = new ArrayList<ArrayList<Point>>();
    private ArrayList<Point> points;
    private ArrayList<Color> allColor = new ArrayList<Color>();
    private ArrayList<Integer> allSize = new ArrayList<Integer>();
    private Color color;
    private int size;

    public enum Type {

        PENCIL, LINE, CIRCLE
    };
    public Type type = Type.PENCIL;
    private Point start;
    private Point end;
    private int height;
    private int width;

    public DrawingPanel() {

        MouseAdapter mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (type != Type.CIRCLE) {
                    start = e.getPoint();
                    System.out.println("pressed");
                    points = new ArrayList<Point>();
                    allPoints.add(points);

                    points.add(new Point(e.getX(), e.getY()));
                    allColor.add(color);
                    allSize.add(size);
                } else {
                    start = e.getPoint();
                    points = new ArrayList<Point>();
                    allPoints.add(points);
                    points.add(new Point(e.getX(), e.getY()));
                    allColor.add(color);
                    allSize.add(null);
                }
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (type != Type.CIRCLE) {
                    end = e.getPoint();
                    if (type == Type.PENCIL) {
                        points.add(new Point(e.getX(), e.getY()));
                    }
                }
                if (type == Type.CIRCLE) {
                    height = (e.getY() - start.y);
                    width = (e.getX() - start.x);
                }

                repaint();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (type == Type.LINE) {
                    points.add(new Point(e.getX(), e.getY()));
                    
                    repaint();
                }
                //this code is only if we will imlement a new panel for each draw
                if (type == Type.PENCIL) {
                    allPanels.add(DrawingPanel.this);
                }

            }
        };
        System.out.println("just a try");

        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        int z = 0;
        for (ArrayList<Point> points : allPoints) {

            //for(Integer size:allSize){
            //for(Color color:allColor){
            if (allSize.get(z) != null) {//if its not a circle its has a size
                Point last = null;
                for (Point point : points) {
                    if (last != null) {
                        g2.setStroke(new BasicStroke(allSize.get(z)));
                        g2.setColor(allColor.get(z));
                        g2.drawLine(last.x, last.y, point.x, point.y);

                    }
                    last = point;
                }

                //}
                //}
            }
            if (allSize.get(z) == null) {
                for (Point point : points) {
                    g2.setColor(allColor.get(z));
                    g2.fillOval(point.x, point.y, width, height);
                }
            }
            z++;
        }
        if (type == Type.LINE) {
            g2.drawLine(start.x, start.y, end.x, end.y);
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void newDraw() {
        DrawingPanel hjk = this;
        hjk = new DrawingPanel();
    }

}
