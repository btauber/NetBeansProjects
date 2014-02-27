package chaseme;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ChaseMe extends JFrame{

    int cX = 0;
    int cY = 0;
    int pX = 450;
    int pY = 450;
    Player p;
    Cat c;
    Thread tc;
    boolean catched = false;
    
    public void newTread(){
        new Thread(new Runnable(){

            @Override
            public void run() {
                while(condition()){
                    try {
                        Thread.sleep(100);
                       
                    } catch (InterruptedException ex) {
                        }
                }
                catched = true;
                }
        }).start();
    }
    
    public boolean condition(){
        if((cX < pX+20)&(cX > pX-60) & (cY < pY+20)&(cY>pY-60)){
            return false;
        }
        return true;
    }
    public void redrawPiece() {
       p.setLocation(pX, pY);
    }
    
    public ChaseMe() {
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                p = new Player();
                add(p);
                p.setLocation(pX,pY);
            }
        }).start();
        
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                c = new Cat();
                add(c);
                
                while(catched == false){
                    if(cX<pX)
                        cX+=40;
                    else
                        cX-=40;
                    if(cY<pY)
                        cY+=40;
                    else
                        cY-=40;
                    c.setLocation(cX, cY);
                    try {
                        Thread.sleep(550);
                    } catch (InterruptedException ex) {
                        return;
                        }
                    
                }
                JOptionPane.showMessageDialog(ChaseMe.this,"You Lost");
                
            }
        }).start();
        
        
        addKeyListener(new KeyAdapter(){

           
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_LEFT:
                        pX = pX - 40;
                        redrawPiece();
                        break;
                    case KeyEvent.VK_RIGHT:
                        pX = pX + 40;
                        redrawPiece();
                        break;
                    case KeyEvent.VK_DOWN:
                        pY = pY + 40; 
                        redrawPiece();
                        break;
                    case KeyEvent.VK_UP:
                        pY = pY - 40;
                        redrawPiece();
                        break;
                }
                }

            
        });
        
        newTread();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                ChaseMe cm = new ChaseMe();
                cm.setVisible(true);
                
                }
        });
    
    }
}
