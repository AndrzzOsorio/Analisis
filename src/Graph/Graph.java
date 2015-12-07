/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import Code.Point;
import java.util.LinkedList;

/**
 *
 * @author 4NDR35
 */
public class Graph {

    private LinkedList<Node> Node;
    private LinkedList<Edge> Edge;

    public Graph() {
    }

    public Graph(LinkedList<Node> Node, LinkedList<Edge> Edge) {
        this.Node = Node;
        this.Edge = Edge;
    }

    public void add(Point p) {
        for (int i = 0; i < Node.size(); i++) {
            if (Node.get(i).getNodo().getCoordx() == p.getCoordx() && Node.get(i).getNodo().getCoordy()
                    == p.getCoordy()) {
                break;
            } else if (i == Node.size()) {
                Node.add(new Node(p));
            }
        }
    }

    /**
     * @return the Node
     */
    public LinkedList<Node> getNode() {
        return Node;
    }

    /**
     * @param Node the Node to set
     */
    public void setNode(LinkedList<Node> Node) {
        this.Node = Node;
    }

    /**
     * @return the Edge
     */
    public LinkedList<Edge> getEdge() {
        return Edge;
    }

    /**
     * @param Edge the Edge to set
     */
    public void setEdge(LinkedList<Edge> Edge) {
        this.Edge = Edge;
    }
}
