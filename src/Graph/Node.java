package Graph;

import Code.Point;
import java.util.LinkedList;

public class Node {

    private LinkedList<Edge> Aristas;
    private Point nodo;

    public Node(Point nodo) {
        Aristas = new LinkedList<Edge>();
        this.Aristas = Aristas;
        this.nodo = nodo;
    }

    public Node() {

    }

    /**
     * @return the Aristas
     */
    public LinkedList<Edge> getAristas() {
        return Aristas;
    }

    /**
     * @param Aristas the Aristas to set
     */
    public void setAristas(LinkedList<Edge> Aristas) {
        this.Aristas = Aristas;
    }

    /**
     * @return the nodo
     */
    public Point getNodo() {
        return nodo;
    }

    /**
     * @param nodo the nodo to set
     */
    public void setNodo(Point nodo) {
        this.nodo = nodo;
    }
}
