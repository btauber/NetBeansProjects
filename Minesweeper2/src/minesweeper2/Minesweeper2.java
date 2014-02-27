package minesweeper2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class Minesweeper2 extends JFrame {

    JLabel timmer = new JLabel();
    int rows = 10;
    int columns = 10;
    int bombs = 10;
    MinesweeperButton[][] buttons = new MinesweeperButton[rows][columns];

    private void crackIt(MinesweeperButton button, int c, int r) {
        if(button.isClicked()){
            return;
        }
        
        button.setEnabled(false);
        button.setClicked(true);
        if (button.getNeighboringBombs() > 0) {
               button.setText("" + button.getNeighboringBombs());
            return;
        } else {

            for (int i = c - 1; i <= c + 1; i++) {
                for (int j = r - 1; j <= r + 1; j++) {
                    
                    if (i < 0 || i >= rows ||
                     j < 0 || j >= columns ||
                     (i == c && j == r)) {
                     continue;
                    }
                    
                    crackIt(buttons[i][j], i, j);
                    
                }
            }
        }
    }

    private void showAll() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                buttons[i][j].setText("" + buttons[i][j].getNeighboringBombs());
                if (buttons[i][j].isBomb()) {
                    buttons[i][j].setText("B");
                }
            }
        }
    }

    private void placeBomb() {
        Random random = new Random();
        while (true) {
            int r = random.nextInt(rows);
            int c = random.nextInt(columns);
            if (!buttons[r][c].isBomb()) {
                buttons[r][c].setIsBomb(true);
                for (int i = r - 1; i <= r + 1; i++) {
                    for (int j = c - 1; j <= c + 1; j++) {
                        if (i < 0 || i >= rows
                                || j < 0 || j >= columns
                                || (i == r && j == c)) {
                            continue;
                        }

                        buttons[i][j].setNeighboringBombs(
                                buttons[i][j].getNeighboringBombs() + 1);
                    }
                }
                break;
            }
        }
    }

    private void placeBombs() {
        for (int i = 0; i < bombs; i++) {
            placeBomb();
        }
    }

    private void checkButton(MinesweeperButton button) {
        if (button.isBomb()) {
            button.setText("BOMB");
            JOptionPane.showMessageDialog(this, "Game Over!");
        } else {//if (button.getNeighboringBombs() == 0) {
            for (int c = 0; c < buttons.length; c++) {
                for (int r = 0; r < buttons[c].length; r++) {
                    if (button.equals(buttons[c][r])) {
                        crackIt(buttons[c][r], c, r);

                    }
                }

            }
                
        }

    }

    public void addButtons(JPanel board) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final MinesweeperButton button = new MinesweeperButton();
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        checkButton(button);
                    }
                });
               MouseListenImpel mouseListener = new MouseListenImpel(){
                    @Override
                        public void mousePressed(MouseEvent e) {
                           if(e.getButton() == MouseEvent.BUTTON3){
                                button.setText("FLAG");
                                button.setEnabled(false);
                            }else{
                               checkButton(button); 
                            }
                        }
                };
               button.addMouseListener(mouseListener);
                board.add(button, i, j);
                buttons[i][j] = button;
            }
        }
    }

    public Minesweeper2() {
        
        Runnable updateGUI = new Runnable() {  
                public void run() {  
                    int timer = 0;
                    while(true){
                        timer++;
                            try {
                                Thread.sleep(1000);
                            } 
                            catch (InterruptedException ex) {}
                            timmer.setText(""+timer);
                    }
                }  
            };  
        Thread t = new Thread(updateGUI);  
        t.start();  
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("MINESWEEPER");
        JPanel top = new JPanel();
        JLabel title = new JLabel("MINESWEEPER", JLabel.CENTER);
        title.setForeground(Color.darkGray);
        title.setFont(new Font(title.getName(), Font.PLAIN, 24));
        top.add(title,BorderLayout.CENTER);
        top.add(timmer,BorderLayout.LINE_END);
        
        
        add(top, BorderLayout.NORTH);
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(rows, columns));
        addButtons(board);
        placeBombs();
        add(board, BorderLayout.CENTER);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new Minesweeper2();
    }
}
