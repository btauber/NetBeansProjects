package tetris;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class TetrisPanel extends JPanel{
    int topLeft;
    int topRight;
    int bottemLeft;
    int bottemRight;
    Point point;
    public TetrisPanel() {
        point = new Point();
        point.x = 50;
        point.y =20;
        
        Runnable updateGUI = new Runnable() {  
                public void run() {  
                    
                    while(point.y < 650){
                       
                        repaint();
                            try {
                                Thread.sleep(1000);
                            } 
                            catch (InterruptedException ex) {}
                             point.y = point.y + 50;
                    }
                }  
            };  
        Thread t = new Thread(updateGUI);  
        t.start();  
        repaint();
        
    }
    
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        //g2.setStroke(new BasicStroke(50));
        g2.setColor(Color.RED);
        //g2.fill3DRect(point.x, point.y, 25, 50, true);
        g2.drawString("HI ESTY",50, 50);
        //g2.drawOval(point.x, point.y, 25, 50);
        //g2.fillOval(point.x, point.y, 25, 50);
        //g2.drawLine(point.x + 50, point.y, point.x + 100, point.y);
        //g2.drawLine(point.x, point.y + 50, point.x + 50, point.y + 50);
        
        /*g.drawLine(point.x + 50, point.y, point.x + 150, point.y);
        g.drawLine(point.x + 50, point.y, point.x + 50, point.y + 100);
        g.drawLine(point.x, point.y + 50, point.x + 150, point.y + 50);
        g.drawLine(point.x, point.y + 100, point.x + 100, point.y + 100);
        g.drawLine(point.x, point.y + 50, point.x, point.y + 100);
        g.drawLine(point.x + 100, point.y, point.x + 100, point.y + 100);
        g.drawLine(point.x +150, point.y, point.x + 150, point.y + 50);
        /*g.drawLine(point.x, point.y, point.x +150, point.y);
        g.drawLine(point.x, point.y +50, point.x +150, point.y+50);
        g.drawLine(point.x, point.y, point.x , point.y +50);
        g.drawLine(point.x + 150, point.y, point.x +150, point.y + 50);*/
    }
    
    public void setPointX(int i){
        point.x +=i;
    }
            
}
