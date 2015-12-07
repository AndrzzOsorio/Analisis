/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author 4NDR35
 */
public class Edge {

    private int Weight;
    private Node Origin;
    private Node End;

    public Edge() {
    }

    public Edge(int Weight, Node Origin, Node End) {
        this.Weight = Weight;
        this.Origin = Origin;
        this.End = End;
    }
    

    /**
     * @return the Weight
     */
    public int getWeight() {
        return Weight;
    }

    /**
     * @param Weight the Weight to set
     */
    public void setWeight(int Weight) {
        this.Weight = Weight;
    }

    /**
     * @return the Origin
     */
    public Node getOrigin() {
        return Origin;
    }

    /**
     * @param Origin the Origin to set
     */
    public void setOrigin(Node Origin) {
        this.Origin = Origin;
    }

    /**
     * @return the End
     */
    public Node getEnd() {
        return End;
    }

    /**
     * @param End the End to set
     */
    public void setEnd(Node End) {
        this.End = End;
    }
}
