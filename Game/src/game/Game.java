

package game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Game extends Canvas implements Runnable {
     public static int width = 300;
     public static int hight = width / 16 * 9;
     public static int scale = 3;
     private Thread thread;
     private JFrame jFrame;
     private boolean running = false;
     public Game(){
         Dimension size = new Dimension(width * scale, hight * scale);
         setPreferredSize(size);
         jFrame = new JFrame();
         
     }
     public synchronized void start(){
         thread = new Thread(this,"Display");
         thread.start();
     }
     public synchronized void stop(){
         running = false;
         try{
             thread.join();
         }catch(InterruptedException e){
             
         }
     }
     public void run(){
         while(running){
             update();
             render();
         }
     }
     public void update(){
         
     }
     public void render(){
         
     }
    public static void main(String[] args) {
       Game game = new Game();
       game.jFrame.setResizable(false);
       game.jFrame.setTitle("Rain");
       game.jFrame.add(game);
       game.jFrame.pack();
       game.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       game.jFrame.setLocationRelativeTo(null);
       game.jFrame.setVisible(true);
       game.start();
    }
    
}
