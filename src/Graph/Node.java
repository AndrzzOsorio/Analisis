
package Graph;


public class Node {
private int posx;
private int posy;

    public Node(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }

    public Node() {
    }

    /**
     * @return the posx
     */
    public int getPosx() {
        return posx;
    }

    /**
     * @param posx the posx to set
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    /**
     * @return the posy
     */
    public int getPosy() {
        return posy;
    }

    /**
     * @param posy the posy to set
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }

}
