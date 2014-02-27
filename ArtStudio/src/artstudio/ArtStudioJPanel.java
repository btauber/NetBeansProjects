package artstudio;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ArtStudioJPanel extends JPanel{
    int i = 0;
    ArrayList<PaintSteps> paintStepsArray = new ArrayList<>();
    Point pointStart = null;
        Point pointEnd   = null;
        public ArtStudioJPanel(){
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    pointStart = e.getPoint();
                    System.out.println("Pressed"+i++);
                }

                public void mouseReleased(MouseEvent e) {
                    paintStepsArray.add(new PaintSteps(pointStart,pointEnd));
                    pointStart = null;
                    System.out.println("Relesed"+i++);
                }
                @Override
                public void mouseMoved(MouseEvent e) {
                    
                   pointEnd = e.getPoint();
                   pointStart = null;
                   System.out.println("Moved"+i++);
                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                

                public void mouseDragged(MouseEvent e) {
                    
                    //pointStart=e.getPoint();
                    pointEnd = e.getPoint();
                    paintStepsArray.add(new PaintSteps(pointStart,pointEnd));
                    pointStart = pointEnd;
                    repaint();
                    System.out.println("Dragged"+i++);
                    innerEvent();
                   
                }
            });
        }
        public void paint(Graphics g) {
            super.paint(g);
            if (pointStart != null) {
                g.setColor(Color.RED);
                
                for (PaintSteps steps: paintStepsArray){
                    //for (int j = 0;j<5;j++){
                      //g.draw3DRect(steps.getStart().x,steps.getStart().y,5,5,true); 
                   // g.fillRect(steps.getStart().x,steps.getStart().y,5,5);
                    g.drawLine(steps.getStart().x,steps.getStart().y,steps.getEnd().x,steps.getEnd().y);
                    //}
                }
                g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
                //g.fillRect(pointStart.x,pointStart.y,5,5);
                //g.draw3DRect(pointStart.x,pointStart.y,5,5,true);
            }
        }
        
        public void innerEvent() {
            
        }
    }/*;
    f.add(p);
    f.setVisible(true); 
}*/
