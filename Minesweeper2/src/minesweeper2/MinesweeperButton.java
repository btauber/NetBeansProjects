package minesweeper2;

import javax.swing.JButton;

public class MinesweeperButton extends JButton {
    private int neighboringBombs;
    private boolean isBomb;
    private boolean clicked;

    public boolean isBomb() {
        return isBomb;
    }

    public void setIsBomb(boolean isBomb) {
        this.isBomb = isBomb;
    }

    public int getNeighboringBombs() {
        return neighboringBombs;
    }

    public void setNeighboringBombs(int neighboringBombs) {
        this.neighboringBombs = neighboringBombs;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
