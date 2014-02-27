package buttongame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class ButtonGame extends JFrame {
    private static ImageIcon coin = new ImageIcon("image/coin.png");
    Random random = new Random();
    int y = 0;
    int x = 0;
    JButton clickMe = new JButton();
    
    private ActionListener getButtonAction() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Heloo");
              
                clickMe.setLocation(x, y);
            }
        };
        return action;
    }

    public ButtonGame() {
        setSize(700,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BUTTON GAME");
        
        
        
        JMenuBar menues = new JMenuBar();
        JMenu file = new JMenu("FILE");
        JMenu diffeclty = new JMenu("Diffeclty");
        JRadioButtonMenuItem easy = new JRadioButtonMenuItem("easy");
        diffeclty.add(easy);
        file.add(diffeclty);
        menues.add(file);
        add(menues);
        setJMenuBar(menues);
        JPanel board = new JPanel();
        board.setLayout(null);
        board.setBackground(Color.red);
        final Timer timer = new Timer(0, getButtonAction());
        //final JButton clickMe = new JButton();
        clickMe.setIcon(coin);
        clickMe.setBackground(Color.red);
        clickMe.addMouseListener(new MouseAdapter(){
        public void MousePressed(MouseEvent e){
        JOptionPane.showMessageDialog(null, "You Won!");
        }});
        clickMe.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You Won!");
                }
        });
        
        setLayout(null);
        
        clickMe.setSize(30,30);
        
        
        add(clickMe);
        this.addMouseMotionListener(new MouseAdapter(){
            public void mouseMoved(MouseEvent e){
       //y = e.getX();x=e.getY();
                final Point location = clickMe.getLocation();
                 System.out.println(""+x+y);
       if(e.getX()> location.x-80&&e.getX() < location.x + 80 &&e.getY()> location.y-80&&e.getY() < location.y + 80){
      // if((location.x < e.getX()+150 ||location.x > e.getX() -150) &&(location.y < e.getY()+150 ||location.y > e.getY() -150))
                y = random.nextInt(650);
                x = random.nextInt(650);
                //System.out.println(""+x+y);
        timer.start();
       }
            System.out.println(e.getX()+" "+e.getY());}});
        //clickMe.setLocation(x, y);
        setVisible(true);
        
        
    }
    public static void main(String[] args) {
        new ButtonGame();
    }
    
}
