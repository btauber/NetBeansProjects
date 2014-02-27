package trymytetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class TryMyTetris extends JFrame{

    public TryMyTetris() {
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        final TetrisPanel tp = new TetrisPanel();
        tp.setBackground(Color.WHITE);
        add(tp);
        setVisible(true);
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    tp.point.x+=50;
                }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    tp.point.x-=50;
                }
               
                }
                

            @Override
            public void keyReleased(KeyEvent e) {
                }
        });
    }
   
    public static void main(String[] args) {
        new TryMyTetris();
        }
    
}
