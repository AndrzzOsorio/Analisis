/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import Code.*;
import java.util.LinkedList;

/**
 *
 * @author 4NDR35
 */
public class Graph {

    private LinkedList<Node> node;
    private LinkedList<Edge> edge;
    private LinkedList<Line> lines;
    private LinkedList<Point> intersectionpoints;
    private LinkedList<Point> actualpoints;
    private double[][] roads;
    LinkedList<Point> ListaVertices;

    public Graph() {
        node = new LinkedList<Node>();
        edge = new LinkedList<Edge>();
        lines = new LinkedList<>();
        intersectionpoints = new LinkedList<>();
        actualpoints = new LinkedList<>();
        ListaVertices = new LinkedList<>();

    }

    public void add(Point p) {
        for (int i = 0; i < getNode().size(); i++) {
            if (getNode().get(i).getNode().getCoordx() == p.getCoordx() && getNode().get(i).getNode().getCoordy() == p.getCoordy()) {
                break;
            } else if (i == getNode().size()) {
                getNode().add(new Node(p));
            }
        }
    }

    public LinkedList<Point> intersectionnodes(int h, int w) {
        int id = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getOrientation() == 1) {
                if (lines.get(i).getStart().getCoordx() != 0) {
                    Point p = new Point(lines.get(i).getStart().getCoordx(), lines.get(i).getStart().getCoordy(), id);
                    id++;
                    if (!getIntersectionpoints().contains(p)) {
                        getIntersectionpoints().add(p);
                        System.out.println(p.getCoordx() + " " + p.getCoordy());
                        this.add(p);
                    } else {
                        p = null;
                    }

                }
                if (lines.get(i).getEnd().getCoordx() != w) {
                    Point p = new Point(lines.get(i).getEnd().getCoordx(), lines.get(i).getEnd().getCoordy(), id);
                    id++;
                    if (!getIntersectionpoints().contains(p)) {
                        getIntersectionpoints().add(p);
                        System.out.println(p.getCoordx() + " " + p.getCoordy());
                        this.add(p);
                    } else {
                        p = null;
                    }
                }
            }
            if (lines.get(i).getOrientation() == -1) {
                if (lines.get(i).getStart().getCoordy() != 0) {
                    Point p = new Point(lines.get(i).getStart().getCoordx(), lines.get(i).getStart().getCoordy(), id);
                    id++;
                    if (!getIntersectionpoints().contains(p)) {
                        getIntersectionpoints().add(p);
                        System.out.println(p.getCoordx() + " " + p.getCoordy());
                        this.add(p);
                    } else {
                        p = null;
                    }
                }
                if (lines.get(i).getEnd().getCoordy() != w) {
                    Point p = new Point(lines.get(i).getEnd().getCoordx(), lines.get(i).getEnd().getCoordy(), id);
                    id++;
                    if (!getIntersectionpoints().contains(p)) {
                        getIntersectionpoints().add(p);
                        System.out.println(p.getCoordx() + " " + p.getCoordy());
                        this.add(p);
                    } else {
                        p = null;
                    }

                }

            }
        }
        return getIntersectionpoints();

    }

    public void road() {
        setRoads(new double[intersectionpoints.size()][actualpoints.size() + intersectionpoints.size()]);
        for (Point p : actualpoints) {
            road2(p);
        }

    }

    public void road2(Point p) {

        this.organicelines();
        LinkedList<Point> hon2 = new LinkedList<>();
        Line hon = this.lines.get(p.getId());
        if (hon.getOrientation() == -1) {
            for (Point paux : intersectionpoints) {
                if (paux.getCoordx() == hon.getStart().getCoordx()) {
                    hon2.add(paux);
                }
            }
            Point tophon = null;
            Point bothon = null;
            LinkedList<Point> upperpoints = new LinkedList<>();
            LinkedList<Point> lowepoints = new LinkedList<>();

            for (Point hon21 : hon2) {
                if (hon21.getCoordy() < p.getCoordy()) {
                    upperpoints.add(hon21);
                    if ((tophon == null || tophon.getCoordy() < hon21.getCoordy())) {
                        tophon = hon21;
                    }
                } else if (hon21.getCoordy() > p.getCoordy()) {
                    lowepoints.add(hon21);
                    if ((bothon == null || bothon.getCoordy() > hon21.getCoordy())) {
                        bothon = hon21;
                    }
                }
            }
            if (tophon != null) {
                getRoads()[intersectionpoints.indexOf(tophon)][actualpoints.indexOf(p)] = p.getCoordy() - tophon.getCoordy();
            }
            if (bothon != null) {
                getRoads()[intersectionpoints.indexOf(bothon)][actualpoints.indexOf(p)] = bothon.getCoordy() - p.getCoordy();
            }
            organicePointsy(upperpoints);
            for (int i = 1; i < upperpoints.size(); i++) {
                //hacer adyacencia desde puntosIzquierda.get(i-1) hasta puntosIzquierda.get(i)  
                getRoads()[intersectionpoints.indexOf(upperpoints.get(i - 1))][actualpoints.size() + intersectionpoints.indexOf(upperpoints.get(i))] = upperpoints.get(i).getCoordy() - upperpoints.get(i - 1).getCoordy();

            }
            organicePointsy(lowepoints);
            for (int i = 1; i < lowepoints.size(); i++) {
                //hacer adyacencia desde puntosDerecha.get(i-1) hasta puntosDerecha.get(i) 
                getRoads()[intersectionpoints.indexOf(lowepoints.get(i - 1))][actualpoints.size() + intersectionpoints.indexOf(lowepoints.get(i))] = lowepoints.get(i).getCoordy() - lowepoints.get(i - 1).getCoordy();

            }

        } else if (hon.getOrientation() == 1) {
            for (Point paux : intersectionpoints) {
                if (paux.getCoordy() == hon.getStart().getCoordy()) {
                    hon2.add(paux);
                }
            }
            Point lefthon = null;
            Point righthon = null;
            LinkedList<Point> leftpoints = new LinkedList<>();
            LinkedList<Point> rightpoints = new LinkedList<>();

            for (Point hon21 : hon2) {
                if (hon21.getCoordx() < p.getCoordx()) {
                    leftpoints.add(hon21);
                    if ((lefthon == null || lefthon.getCoordx() < hon21.getCoordx())) {
                        lefthon = hon21;
                    }

                } else if (hon21.getCoordx() > p.getCoordx()) {
                    rightpoints.add(hon21);
                    if ((righthon == null || righthon.getCoordx() > hon21.getCoordx())) {
                        righthon = hon21;
                    }
                }
            }
            if (lefthon != null) {
                getRoads()[intersectionpoints.indexOf(lefthon)][actualpoints.indexOf(p)] = p.getCoordx() - lefthon.getCoordx();
            }
            if (righthon != null) {
                getRoads()[intersectionpoints.indexOf(righthon)][actualpoints.indexOf(p)] = righthon.getCoordx() - p.getCoordx();
            }
            organicePointsx(leftpoints);
            for (int i = 1; i < leftpoints.size(); i++) {
                //hacer adyacencia desde puntosIzquierda.get(i-1) hasta puntosIzquierda.get(i)  
                getRoads()[intersectionpoints.indexOf(leftpoints.get(i - 1))][actualpoints.size() + intersectionpoints.indexOf(leftpoints.get(i))] = leftpoints.get(i).getCoordx() - leftpoints.get(i - 1).getCoordx();

            }
            organicePointsx(rightpoints);
            for (int i = 1; i < rightpoints.size(); i++) {
                //hacer adyacencia desde puntosDerecha.get(i-1) hasta puntosDerecha.get(i) 
                getRoads()[intersectionpoints.indexOf(rightpoints.get(i - 1))][actualpoints.size() + intersectionpoints.indexOf(rightpoints.get(i))] = rightpoints.get(i).getCoordx() - rightpoints.get(i - 1).getCoordx();

            }

        }

    }

    public void organicelines() {
        for (int j = 0; j < lines.size(); j++) {
            for (int k = j + 1; k < lines.size(); k++) {
                if (lines.get(j).getId() > lines.get(k).getId()) {
                    Line aux = lines.get(j);
                    lines.set(j, lines.get(k));
                    lines.set(k, aux);
                }
            }
        }
    }

    public void organicePointsx(LinkedList<Point> p) {
        for (int j = 0; j < p.size(); j++) {
            for (int k = j + 1; k < p.size(); k++) {
                if (p.get(j).getCoordx() > p.get(k).getCoordx()) {
                    Point aux = p.get(j);
                    p.set(j, p.get(k));
                    p.set(k, aux);
                }
            }
        }
    }

    public void organicePointsy(LinkedList<Point> p) {
        for (int j = 0; j < p.size(); j++) {
            for (int k = j + 1; k < p.size(); k++) {
                if (p.get(j).getCoordy() > p.get(k).getCoordy()) {
                    Point aux = p.get(j);
                    p.set(j, p.get(k));
                    p.set(k, aux);
                }
            }
        }
    }

    public void pritnroads() {
        for (int x = 0; x < getRoads().length; x++) {
            System.out.print("|");
            for (int y = 0; y < getRoads()[x].length; y++) {
                System.out.print(getRoads()[x][y]);
                if (y != getRoads()[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }

    public Graph Prim(double[][] Matriz) {  //Llega la matriz a la que le vamos a aplicar el algoritmo
        Graph gr = new Graph();
        gr.setRoads(Matriz);
        gr.pritnroads();
        System.out.println("\n");
        boolean[] marcados = new boolean[actualpoints.size() + intersectionpoints.size()]; //Creamos un vector booleano, para saber cuales están marcados
        for (int i = 0; i < actualpoints.size(); i++) {
            ListaVertices.add(actualpoints.get(i));
        }
        for (int i = 0; i < intersectionpoints.size(); i++) {
            ListaVertices.add(intersectionpoints.get(i));
        }
        Point vertice = ListaVertices.get(0); //Le introducimos un nodo aleatorio, o el primero
        gr.setActualpoints(actualpoints);
        gr.setIntersectionpoints(intersectionpoints);
        gr.setRoads(AlgPrim(Matriz, marcados, vertice, new double[actualpoints.size() + intersectionpoints.size()][actualpoints.size() + intersectionpoints.size()])); //Llamamos al método recursivo mandándole 
        gr.pritnroads();
        return gr;
    }                                                                                    //un matriz nueva para que en ella nos 
    //devuelva el árbol final

    private double[][] AlgPrim(double[][] Matriz, boolean[] marcados, Point vertice, double[][] Final) {

        marcados[ListaVertices.indexOf(vertice)] = true;//marcamos el primer nodo
        double aux = -1;
        if (!TodosMarcados(marcados)) { //Mientras que no todos estén marcados
            for (int i = 0; i < marcados.length; i++) { //Recorremos sólo las filas de los nodos marcados
                if (marcados[i]) {
                    for (int j = 0; j < Matriz.length; j++) {
                        if (Matriz[i][j] != 0) {        //Si la arista existe
                            if (!marcados[j]) {         //Si el nodo no ha sido marcado antes
                                if (aux == -1) {        //Esto sólo se hace una vez
                                    aux = Matriz[i][j];
                                } else {
                                    aux = Math.min(aux, Matriz[i][j]); //Encontramos la arista mínima
                                }
                            }
                        }
                    }
                }
            }
            //Aquí buscamos el nodo correspondiente a esa arista mínima (aux)
            for (int i = 0; i < marcados.length; i++) {
                if (marcados[i]) {
                    for (int j = 0; j < Matriz.length; j++) {
                        if (Matriz[i][j] == aux) {
                            if (!marcados[j]) { //Si no ha sido marcado antes
                                Final[i][j] = aux; //Se llena la matriz final con el valor
                                Final[j][i] = aux;//Se llena la matriz final con el valor
                                return AlgPrim(Matriz, marcados, ListaVertices.get(j), Final); //se llama de nuevo al método con
                                //el nodo a marcar
                            }
                        }
                    }
                }
            }
        }
        return Final;
    }

    public boolean TodosMarcados(boolean[] vertice) { //Método para saber si todos están marcados
        for (boolean b : vertice) {
            if (!b) {
                return b;
            }
        }
        return true;
    }

    public double[][] ToSquare() {
      double[][] m = new double[actualpoints.size()+intersectionpoints.size()][actualpoints.size()+intersectionpoints.size()];
        for (int i = actualpoints.size(); i < m.length; i++) {
            for (int j = 0; j < m.length ; j++) {
                if(m[i][j] == 0){
                m[i][j] = this.getRoads()[i-actualpoints.size()][j];
                m[j][i] = this.getRoads()[i-actualpoints.size()][j];
            }
            }
        }
        return m;
    }

    /**
     * @return the node
     */
    public LinkedList<Node> getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(LinkedList<Node> node) {
        this.node = node;
    }

    /**
     * @return the edge
     */
    public LinkedList<Edge> getEdge() {
        return edge;
    }

    /**
     * @param edge the edge to set
     */
    public void setEdge(LinkedList<Edge> edge) {
        this.edge = edge;
    }

    /**
     * @return the lines
     */
    public LinkedList<Line> getLines() {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(LinkedList<Line> lines) {
        this.lines = lines;
    }

    /**
     * @return the intersectionpoints
     */
    public LinkedList<Point> getIntersectionpoints() {
        return intersectionpoints;
    }

    /**
     * @param intersectionpoints the intersectionpoints to set
     */
    public void setIntersectionpoints(LinkedList<Point> intersectionpoints) {
        this.intersectionpoints = intersectionpoints;
    }

    /**
     * @return the actualpoints
     */
    public LinkedList<Point> getActualpoints() {
        return actualpoints;
    }

    /**
     * @param actualpoints the actualpoints to set
     */
    public void setActualpoints(LinkedList<Point> actualpoints) {
        this.actualpoints = actualpoints;
    }

    /**
     * @return the roads
     */
    public double[][] getRoads() {
        return roads;
    }

    /**
     * @param roads the roads to set
     */
    public void setRoads(double[][] roads) {
        this.roads = roads;
    }

}
