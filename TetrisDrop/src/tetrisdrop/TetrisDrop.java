package tetrisdrop;

import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class TetrisDrop extends JFrame {
    private int maxHeight;
    private int startingX;
    private int x;
    private int y;
    private boolean fast;
    private boolean paused;
    private Random random = new Random();
    private TetrisPiece tp;
    
    private void redrawPiece() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                tp.setLocation(x, y);
                
            }
        });
    }
    
    private void gameLoop() {
        while(true) {
            if (random.nextInt(1000) % 2 == 0) {
                tp = new OPiece();
            } else {
                tp = new IPiece();
            }
            x = startingX;
            y = 0;
            tp.setLocation(x, y);
            add(tp);

            while (y < maxHeight) {
                try {
                    Thread.sleep(fast ? 250 : 750);
                    if (! paused) {
                        y += TetrisPiece.SEGMENT_SIZE;
                        redrawPiece();
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public TetrisDrop() {
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        maxHeight = this.getContentPane().getHeight() - TetrisPiece.SEGMENT_SIZE;
        startingX = (this.getContentPane().getWidth() - (2 * TetrisPiece.SEGMENT_SIZE)) / 2;
        
        // not actually a good idea to start a thread from a constructor - should
        // move to method called on instance after creation
        new Thread(new Runnable() {
            @Override
            public void run() {
                gameLoop();
            }
        }).start();
    
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_LEFT:
                        x = x - TetrisPiece.SEGMENT_SIZE;
                        redrawPiece();
                        break;
                    case KeyEvent.VK_RIGHT:
                        x = x + TetrisPiece.SEGMENT_SIZE;
                        redrawPiece();
                        break;
                    case KeyEvent.VK_DOWN:
                        fast = true;
                        break;
                    case KeyEvent.VK_P:
                        paused = ! paused;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                fast = false;
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TetrisDrop();
            }
        });
    }
}
