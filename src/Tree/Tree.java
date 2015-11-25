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
public class Tree<T> {
    
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }
    

    public Tree() {
    }

    /**
     * @return the root
     */
    public Node<T> getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Node<T> root) {
        this.root = root;
    }
    
    
}

