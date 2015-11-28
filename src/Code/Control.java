/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import Tree.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author 4NDR35
 */
public class Control {

    private Tree<Data> t;
    private LinkedList<Area> rectangles;
    private LinkedList<Color> colorsls;

    public Control() {
        t = new Tree<>(new Node<Data>());
        rectangles = new LinkedList<>();
        colorsls = new LinkedList<>();

    }

    /**
     * @return the t
     */
    public Tree getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(Tree t) {
        this.t = t;

    }

    public void standar(LinkedList<Point> p, int w, int h) {
        buildtree(t.getRoot(), p, 0, 0, w, h, 1);
    }

    public void buildtree(Node<Data> root, LinkedList<Point> p, double x, double y, int w, int h, int orientation) {
        if (p.size() > 1) {
            double minor = 999999;
            double temp;
            int index = -1;
            LinkedList<Point> pts;

            if (orientation == 1) {
                pts = organiceY(p);
            } else {
                pts = organiceX(p);
            }
            Point temporalpoint = p.getFirst();
            if (root != null) {
                for (int i = 0; i < pts.size(); i++) {
                    temp = hypotenusecompare(pts.get(i), new Point(x + (w / 2), y + (h / 2)));
                    if (minor > temp) {
                        minor = temp;
                        temporalpoint = pts.get(i);
                        index = i;
                    }
                }
                if (orientation == 1) {
                    LinkedList<Point> uperPoints = extract(pts, 0, index);
                    LinkedList<Point> lowerPoints = extract(pts, index + 1, pts.size());
                    Data nData = new Data(new Line(new Point(x, temporalpoint.getCoordy()), new Point(w, temporalpoint.getCoordy())), temporalpoint);
                    root.setElement(nData);
                    if (uperPoints.size() >= 1) {
                        root.setLeft(new Node<Data>());
                        buildtree(root.getLeft(), uperPoints, x, y, w, (int) temporalpoint.getCoordy(), (orientation * (-1)));
                    } else {
                        rectangles.add(new Area((int) x, (int) y, w - (int) x, (int) temporalpoint.getCoordy() - (int) y));
                    }
                    if (lowerPoints.size() >= 1) {
                        root.setRigth(new Node<Data>());
                        buildtree(root.getRigth(), lowerPoints, x, (int) temporalpoint.getCoordy(), w, h, (orientation * (-1)));
                    } else {
                        rectangles.add(new Area((int) x, (int) temporalpoint.getCoordy(), w - (int) x, h - (int) temporalpoint.getCoordy()));
                    }
                } else {
                    LinkedList<Point> leftPoints = extract(pts, 0, index);
                    LinkedList<Point> rightPoints = extract(pts, index + 1, pts.size());
                    Data nData = new Data(new Line(new Point(temporalpoint.getCoordx(), y), new Point(temporalpoint.getCoordx(), h)), temporalpoint);
                    root.setElement(nData);
                    if (leftPoints.size() >= 1) {
                        root.setLeft(new Node<Data>());
                        buildtree(root.getLeft(), leftPoints, x, y, (int) temporalpoint.getCoordx(), h, (orientation * (-1)));
                    } else {
                        rectangles.add(new Area((int) x, (int) y, (int) temporalpoint.getCoordx() - (int) x, h - (int) y));
                    }
                    if (rightPoints.size() >= 1) {
                        root.setRigth(new Node<Data>());
                        buildtree(root.getRigth(), rightPoints, (int) temporalpoint.getCoordx(), y, w, h, (orientation * (-1)));
                    } else {
                        rectangles.add(new Area((int) temporalpoint.getCoordx(), (int) y, w - (int) temporalpoint.getCoordx(), h - (int) y));
                    }
                }

            }
        } else if (p.size() == 1) {
            if (orientation == 1) {

                Data nData = new Data(new Line(new Point(x, p.getFirst().getCoordy()), new Point(w, p.getFirst().getCoordy())), p.getFirst());
                root.setElement(nData);
                Createsquaresy(p.getFirst(), x, y, w, h);

            } else if (orientation == -1) {
                Data nData = new Data(new Line(new Point(p.getFirst().getCoordx(), y), new Point(p.getFirst().getCoordx(), h)), p.getFirst());
                root.setElement(nData);
                Createsquaresx(p.getFirst(), x, y, w, h);
            }
        }

    }

    public double hypotenusecompare(Point a, Point b) {
        double x = Math.hypot(a.getCoordx() - b.getCoordx(), a.getCoordy() - b.getCoordy());
        return x;
    }

    public LinkedList<Point> organiceX(LinkedList<Point> p) {
        LinkedList<Point> mirror = p;
        for (int j = 0; j < mirror.size(); j++) {
            for (int k = j + 1; k < mirror.size(); k++) {
                if (mirror.get(j).getCoordx() > mirror.get(k).getCoordx()) {
                    Point aux = mirror.get(j);
                    mirror.set(j, mirror.get(k));
                    mirror.set(k, aux);
                }
            }
        }
        return mirror;
    }

    public LinkedList<Point> organiceY(LinkedList<Point> p) {
        LinkedList<Point> mirror = p;
        for (int j = 0; j < mirror.size(); j++) {
            for (int k = j + 1; k < mirror.size(); k++) {
                if (mirror.get(j).getCoordy() > mirror.get(k).getCoordy()) {
                    Point aux = mirror.get(j);
                    mirror.set(j, mirror.get(k));
                    mirror.set(k, aux);
                }

            }

        }
        return mirror;

    }

    private LinkedList<Point> extract(LinkedList<Point> pts, int start, int end) {
        LinkedList<Point> sublist = new LinkedList<Point>();
        for (int i = start; i < end; i++) {
            sublist.add(pts.get(i));
        }
        return sublist;
    }

    public void Lines(Graphics g, Node<Data> root) {
        if (root.getElement() != null) {
            root.getElement().getLine().Draw(g);
            if (root.getLeft() != null && root.getLeft().getElement() != null) {
                Lines(g, root.getLeft());
            }
            if (root.getRigth() != null && root.getRigth().getElement() != null) {
                Lines(g, root.getRigth());
            }
        }
    }

    public void Createsquaresx(Point p, double x, double y, int w, int h) {
        Area rec1 = new Area((int) x, (int) y, (int) p.getCoordx() - (int) x, h - (int) y);
        Area rec2 = new Area((int) p.getCoordx(), (int) y, w - (int) p.getCoordx(), h - (int) y);
        if (!rectangles.contains(rec1)) {
            rectangles.add(rec1);
        }
        if (!rectangles.contains(rec2)) {
            rectangles.add(rec2);
        }
    }

    public void Createsquaresy(Point p, double x, double y, int w, int h) {
        Area rec1 = new Area((int) x, (int) y, w - (int) x, (int) p.getCoordy() - (int) y);
        Area rec2 = new Area((int) x, (int) p.getCoordy(), w - (int) x, h - (int) p.getCoordy());
        if (!rectangles.contains(rec1)) {
            rectangles.add(rec1);
        }
        if (!rectangles.contains(rec2)) {
            rectangles.add(rec2);
        }
    }

    public void Newcolor() {
        Color randomColor2 = new Color((int) (Math.random() * 254), (int) (Math.random() * 254), (int) (Math.random() * 254));
        colorsls.add(randomColor2);

    }

    public LinkedList<Area> Colors() {
        for (int i = 0; i < rectangles.size(); i++) {
            paintAreas(rectangles, i);
        }
        return rectangles;
    }

    public void paintAreas(LinkedList<Area> areas, int x) {
        Area a = areas.get(x);
        a.getArea().grow(1, 1);
        if (x == 0) {
            this.Newcolor();
            a.setColor(this.colorsls.getFirst());
        } else {
            Color aux = null;
            boolean analice = true;
            for (Color color : this.colorsls) {
                if (analice && colorselection(a, color, areas)) {
                    aux = color;
                    analice = false;
                }
            }
            if (aux == null) {
                this.Newcolor();
                aux = this.colorsls.getLast();
            }
            a.setColor(aux);
        }
        a.getArea().grow(-1, -1);

    }

    public boolean colorselection(Area a, Color c, LinkedList<Area> areas) {
        boolean b = false;
        //if (a.getColor() != c) {
        for (int i = 0; i < areas.size(); i++) {
            if (a != areas.get(i)) {
                if (a.getArea().intersects(areas.get(i).getArea())) {
                    if (areas.get(i).getColor() == c) {
                        b = false;
                        break;
                    } else {
                        b = true;
                    }
                }
            }
        }
        //}
        return b;
    }

    public void contains(Point p) {
        Rectangle pt = new Rectangle((int) p.getCoordx() - 2, (int) p.getCoordy() - 2, 4, 4);
        for (int i = 0; i < rectangles.size(); i++) {
            if (rectangles.get(i).getArea().intersects(pt)) {
                rectangles.get(i).setColor(Color.yellow);
            }

        }
    }

    public void agrupar(LinkedList<Point> p) {
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getCoordx() < 250 && p.get(i).getCoordy() < 250) {
             p.get(i).setColorpunto(Color.BLUE);
            }
        }
    }

    /**
     * @return the rectangles
     */
    public LinkedList<Area> getRectangles() {
        return rectangles;
    }

    /**
     * @param rectangles the rectangles to set
     */
    public void setRectangles(LinkedList<Area> rectangles) {
        this.rectangles = rectangles;

    }

    /**
     * @return the colorsls
     */
    public LinkedList<Color> getColorsls() {
        return colorsls;
    }

    /**
     * @param colorsls the colorsls to set
     */
    public void setColorsls(LinkedList<Color> colorsls) {
        this.colorsls = colorsls;
    }

    /**
     * @return the minimuncolors
     */
    /**
     * @return the colors
     */
}
