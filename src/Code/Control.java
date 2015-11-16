/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import com.sun.javafx.font.FontResource;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author 4NDR35
 */
public class Control {

    private Tree<Data> t;

    public Control() {
        t = new Tree<>(new Node<Data>());
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
        double minor = 999999;
        double temp = 0;
        int index = -1;
        LinkedList<Point> pts = new LinkedList<>();
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
                }
                if (lowerPoints.size() >= 1) {
                    root.setRigth(new Node<Data>());
                    buildtree(root.getRigth(), lowerPoints, x, (int) temporalpoint.getCoordy(), w, h, (orientation * (-1)));
                }
            } else {
                LinkedList<Point> leftPoints = extract(pts, 0, index);
                LinkedList<Point> rightPoints = extract(pts, index + 1, pts.size());
                Data nData = new Data(new Line(new Point(temporalpoint.getCoordx(), y), new Point(temporalpoint.getCoordx(), h)), temporalpoint);
                root.setElement(nData);
                if (leftPoints.size() >= 1) {
                    root.setLeft(new Node<Data>());
                    buildtree(root.getLeft(), leftPoints, x, y, (int) temporalpoint.getCoordx(), h, (orientation * (-1)));
                }
                if (rightPoints.size() >= 1) {
                    root.setRigth(new Node<Data>());
                    buildtree(root.getRigth(), rightPoints, (int) temporalpoint.getCoordx(), y, w, h, (orientation * (-1)));
                }
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

    private LinkedList<Point> extract(LinkedList<Point> pts, int indIni, int indFin) {
        LinkedList<Point> subPts = new LinkedList<Point>();
        for (int i = indIni; i < indFin; i++) {
            subPts.add(pts.get(i));
        }
        return subPts;
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

}
