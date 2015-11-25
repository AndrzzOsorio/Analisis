/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author 4NDR35
 */
public class Node<T> {
    private T element;
    private Node left;
    private Node rigth;
    

    public Node(T element) {
        this.element = element;
    }

    public Node() {
    }

    

    /**
     * @return the element
     */
    public T getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * @return the rigth
     */
    public Node getRigth() {
        return rigth;
    }

    /**
     * @param rigth the rigth to set
     */
    public void setRigth(Node rigth) {
        this.rigth = rigth;
    }
    
    
}
