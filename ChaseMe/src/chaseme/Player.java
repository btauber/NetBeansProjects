package chaseme;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Player extends JComponent {
    Image image;
    private static Image New_icon ;
    private int playerX = 0;
    private int playerY = 0;
    public Player(){
       
        
        setSize(41,41);
        setBackground(Color.red);
        setLayout(null);
        New_icon= new ImageIcon("barak-obama-icon.png").getImage();
        
    
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        //g2 .setColor(Color.BLUE);
        //g2.fill3DRect(playerX, playerY, 40, 40, true);
        g2.drawImage(New_icon,0,0,getWidth(),getHeight(),null);
       
       
        
    }
    
}
