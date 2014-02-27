package chaseme;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;

public class Cat extends JComponent {
    
    
    private int catX = 0;
    private int catY = 0;
    private static Image New_icon ;
    public Cat(){
        
        setSize(41,41);
        setBackground(Color.red);
        New_icon= new ImageIcon("Diego-icon.png").getImage();
    }
    
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        
        g2.drawImage(New_icon,0,0,getWidth(),getHeight(),null);
    }
    
}
