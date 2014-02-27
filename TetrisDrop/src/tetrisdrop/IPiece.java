package tetrisdrop;

import java.awt.*;

public class IPiece extends TetrisPiece {
    public IPiece() {
        points[0] = new Point(0, 0);
        points[1] = new Point(0, SEGMENT_SIZE);
        points[2] = new Point(0, SEGMENT_SIZE * 2);
        points[3] = new Point(0, SEGMENT_SIZE * 3);
        
        color = Color.RED;
    }
}
