
package Code;

import java.awt.Color;
import java.awt.Graphics;



public class Point {
    
    private double coordx;
    private double coordy;

    public Point() {
    }

    public Point(double coordx, double coordy) {
        this.coordx = coordx;
        this.coordy = coordy;
    }

    /**
     * @return the coordx
     */
    public double getCoordx() {
        return coordx;
    }

    /**
     * @param coordx the coordx to set
     */
    public void setCoordx(double coordx) {
        this.coordx = coordx;
    }

    /**
     * @return the coordy
     */
    public double getCoordy() {
        return coordy;
    }

    /**
     * @param coordy the coordy to set
     */
    public void setCoordy(double coordy) {
        this.coordy = coordy;
    }

    
    
    public void Draw (Graphics g){
        g.drawOval((int)coordx-3, (int)coordy-3, 6, 6);
        g.setColor(Color.black);
        g.fillOval((int)coordx-3, (int)coordy-3, 6, 6);
    }
    }
    
    
    

