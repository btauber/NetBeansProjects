package art;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Art extends JFrame {
    
    public Art() {
        
        
       
           
                DrawingPanel panel = new DrawingPanel();
                
                
                add(panel);
                panel.setOpaque(true);
               
            
                 setVisible(true);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
            new Art();
    }
}
