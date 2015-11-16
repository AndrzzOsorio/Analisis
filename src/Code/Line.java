
package Code;

import java.awt.Graphics;


public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @return the start
     */
    public Point getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public Point getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Point end) {
        this.end = end;
    }
    
    public void Draw(Graphics g){
        g.drawLine((int)(this.getStart().getCoordx()),(int)(this.getStart().getCoordy()),(int)(this.getEnd().getCoordx()), (int)(this.getEnd().getCoordy()));
    }
            
}
