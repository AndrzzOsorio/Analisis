package Code;

import java.awt.Color;
import java.awt.Graphics;

public class Point {

    private double coordx;
    private double coordy;
    private Color pointcolor;

    public Point() {
    }

    public Point(double coordx, double coordy) {
        this.coordx = coordx;
        this.coordy = coordy;
        this.pointcolor = Color.black;
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

    public void Draw(Graphics g) {

        g.setColor(getPointcolor());
        g.fillOval((int) getCoordx() - 3, (int) getCoordy() - 3, 6, 6);
    }

    /**
     * @return the colorpunto
     */
    public Color getPointcolor() {
        return pointcolor;
    }

    /**
     * @param colorpunto the colorpunto to set
     */
    public void setPointcolor(Color colorpunto) {
        this.pointcolor = colorpunto;
    }
}
