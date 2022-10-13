/**
 * @version 1.0.0
 * @author Joseph Dawson
 *
 * Each BST node, containing the data and the child nods
 */
public class BSTNode {
    //the data of the node, and the nodes children
    private Profile researcher;
    private BSTNode l, r;

    /**
     * creates a new node.
     * @param elem the data being stored by the node
     */
    public BSTNode (Profile elem) {
        this.researcher = elem;
        this.l = null;
        this.r = null;

    }

    /**
     * @return the researcher Profile
     */
    public Profile getResearcher() {
        return this.researcher;
    }

    /**
     * @return the left child of the node
     */
    public BSTNode getL() {
        return this.l;
    }

    /**
     *
     * @return the right child of the node
     */
    public BSTNode getR() {
        return r;
    }

    /**
     * set the left child node
     * @param l a node to go as the left child
     */
    public void setL(BSTNode l) {
        this.l = l;
    }

    /**
     * set the right child node
     * @param r a node to go as the right child
     */
    public void setR(BSTNode r) {
        this.r = r;
    }

    /**
     *
     * @return the node as a string,
     * by including the left and right children, the entire tree below the node can be drawn.
     * E.g. if this is a root node, then the entire tree will be printed out by printing the root node.
     */
    @Override
    public String toString() {
        return "{name = " + researcher.getFamilyNames()  +
                ", l= " + l +
                ", r= " + r +
                '}'+ '\n';
    }
}
