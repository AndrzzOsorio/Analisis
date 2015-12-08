package Graph;

import Code.Point;
import java.util.LinkedList;

public class Node {

    private LinkedList<Edge> Edges;
    private Point node;

    public Node(Point node) {
        Edges = new LinkedList<Edge>();
        this.node = node;
    }

    public Node() {

    }

    /**
     * @return the Edges
     */
    public LinkedList<Edge> getEdges() {
        return Edges;
    }

    /**
     * @param Edges the Edges to set
     */
    public void setEdges(LinkedList<Edge> Edges) {
        this.Edges = Edges;
    }

    /**
     * @return the node
     */
    public Point getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(Point node) {
        this.node = node;
    }

   
}
