
package Code;

import java.awt.Color;
import java.awt.Graphics;
import javafx.scene.shape.Circle;


public class Point {
    
    private int coordx;
    private int coordy;
    private int cut;
    

    public Point() {
    }

    public Point(int coordx, int coordy, int cut) {
        this.coordx = coordx;
        this.coordy = coordy;
        this.cut = cut;
        
    }
    
    public void draw (Graphics g){
        
        g.drawOval(getCoordx()-3, getCoordy()-3, 6, 6);
        g.fillOval(getCoordx()-3, getCoordy()-3, 6, 6);
        g.setColor(Color.black);
    }

    /**
     * @return the coordx
     */
    public int getCoordx() {
        return coordx;
    }

    /**
     * @param coordx the coordx to set
     */
    public void setCoordx(int coordx) {
        this.coordx = coordx;
    }

    /**
     * @return the coordy
     */
    public int getCoordy() {
        return coordy;
    }

    /**
     * @param coordy the coordy to set
     */
    public void setCoordy(int coordy) {
        this.coordy = coordy;
    }

    /**
     * @return the cut
     */
    public int getCut() {
        return cut;
    }

    /**
     * @param cut the cut to set
     */
    public void setCut(int cut) {
        this.cut = cut;
    }

    /**
     * @return the area
     */
    
    
}
