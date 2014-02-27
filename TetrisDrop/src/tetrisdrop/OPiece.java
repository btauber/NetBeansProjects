package tetrisdrop;

import java.awt.Color;
import java.awt.Point;

public class OPiece extends TetrisPiece {
    public OPiece() {
        points[0] = new Point(0, 0);
        points[1] = new Point(SEGMENT_SIZE, 0);
        points[2] = new Point(0, SEGMENT_SIZE);
        points[3] = new Point(SEGMENT_SIZE, SEGMENT_SIZE);
        
        color = Color.GREEN;
    }
}
