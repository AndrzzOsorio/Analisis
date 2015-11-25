
package Code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static javafx.scene.paint.Color.color;


public class Area implements Cloneable{
    private double x;
    private double y;
    private int w;
    private int h;
    private Rectangle area;
    private Color color;

    public Area() {
    }

    public Area(double x, double y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        area = new Rectangle((int)x,(int) y, w, h);
        color = null;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the w
     */
    public int getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setW(int w) {
        this.w = w;
    }

    /**
     * @return the h
     */
    public int getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * @return the area
     */
    public Rectangle getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Rectangle area) {
        this.area = area;
    }
    
    public void Draw (Graphics g){
        g.drawRect((int)x, (int)y, w, h);
        g.setColor(getColor());
        g.fillRect((int)x, (int)y, w, h);
    }
    
    @Override
    public Object clone() {
       Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("cannot dupply element");
        }
        return obj;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
}
