package artstudio;

import java.awt.Point;

public class PaintSteps {
    private Point start;
    private Point end;
    public PaintSteps(Point start,Point end) {
        this.start = start;
        this.end = end;
    }
    
    public Point getStart() {
        return start;
    }
    
     public Point getEnd() {
        return end;
    }
}
