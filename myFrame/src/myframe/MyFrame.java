package myframe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class MyFrame {

    public static void main(String[] args) {
        new MyFrame();
    }
    
    public MyFrame()
    {
        JFrame frame = new JFrame();
        frame.setBounds(200, 200, 300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addMouseListener(new myMouseAction());
        frame.addMouseMotionListener(new MyMouseMotion());
        frame.addKeyListener( new MyKeyListener());
        
    }
    
    public class myMouseAction implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Mouse was clicked");
            }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("Mouse was Pressed");
            }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("Mouse was Relesed");
            }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("Mouse was Entered");
            }

        @Override
        public void mouseExited(MouseEvent e) {
            
            }
        
    
}
    
    public class MyMouseMotion implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println("Mouse is Dragging");
            }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println("Mouse is moving");
            }
        
    }
    
    public class MyKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("Key is Typing");
            }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key was Pressed");
            }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("Key is Released");
            }
        
    }
}
