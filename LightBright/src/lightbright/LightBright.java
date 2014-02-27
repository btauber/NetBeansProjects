package lightbright;
        
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class LightBright extends JFrame{
   
    String color ;
    public JPanel addColors() {
        JPanel allColors = new JPanel();
        
        JButton red = new JButton();
        red.setBackground(Color.red);
        red.setText("Red");
        red.setOpaque(true);
        red.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                color = "red";
                }
        });
        allColors.add(red);
        
        JButton yellow = new JButton();
        yellow.setBackground(Color.yellow);
        yellow.setText("Yellow");
        yellow.setOpaque(true);
        yellow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                color = "yellow";
                }
        });
        allColors.add(yellow);
        
        JButton black = new JButton();
        black.setBackground(Color.BLACK);
        black.setText("Black");
        black.setOpaque(true);
        black.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                color = "black";
                }
        });
        allColors.add(black);
        
        JButton pink = new JButton();
        pink.setBackground(Color.pink);
        pink.setText("Pink");
        pink.setOpaque(true);
        pink.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                color = "pink";
                }
        });
        allColors.add(pink);
        
        JButton orange = new JButton();
        orange.setBackground(Color.orange);
        orange.setText("Orange");
        orange.setOpaque(true);
        orange.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                color = "orange";
                }
        });
        allColors.add(orange);
        
        JButton clear = new JButton();
        
        clear.setText("Clear");
        clear.setOpaque(true);
        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                color = "clear";
                }
        });
        allColors.add(clear);
        
        return allColors;
    }
    public void addPanel(JPanel board) {
        for(int x = 0;x < 90;x++) {
            for(int y = 0;y < 100;y++) {
                 final MyJPanel bt = new MyJPanel();
                 bt.setOpaque(true);
                 //allButton[x][y]=bt;
                 //bt.setBorder(BorderFactory.createLineBorder(Color.black,1));
                 MouseListenImpel mouseImpel = new MouseListenImpel(){
                     public void mousePressed(MouseEvent e){
                         if(color.equals("black"))
                             bt.setBackground(Color.black);
                         if(color.equals("pink"))
                             bt.setBackground(Color.pink);
                         if(color.equals("red"))
                             bt.setBackground(Color.red);
                         if(color.equals("orange"))
                             bt.setBackground(Color.orange);
                         if(color.equals("yellow"))
                             bt.setBackground(Color.yellow);
                         if(color.equals("clear"))
                             bt.setBackground(null);
                     }
                 };
                 bt.addMouseListener(mouseImpel);
                 board.add(bt,x,y);
            }
        }
        
    }
    public LightBright() {
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("LIGHTBRIGHT");
        add(addColors(),BorderLayout.NORTH);
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(100,90));
        addPanel(board);
        add(board,BorderLayout.CENTER);
         setVisible(true);
    }
    public static void main(String[] args) {
       new LightBright();
    }
    
}
