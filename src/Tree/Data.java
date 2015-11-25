/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import Code.Line;
import Code.Point;

/**
 *
 * @author 4NDR35
 */
public class Data {
    private Line line;
    private Point point;

    public Data() {
    }

    public Data(Line line, Point point) {
        this.line = line;
        this.point = point;
    }

    /**
     * @return the line
     */
    public Line getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(Line line) {
        this.line = line;
    }

    /**
     * @return the point
     */
    public Point getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(Point point) {
        this.point = point;
    }
    
    
}

