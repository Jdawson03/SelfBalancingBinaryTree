/**
 * @version 1.0.0
 * @author Joseph Dawson
 *
 * This was just for personal exploration because I accidentally gave myself an adverserial data set
 * and wanted to see what solutions to this there were.
 *
 * In a worst case scenario for a BST, the search time effiency is the same as a linked list O(n),
 * in a self-balancing BST the worst case remains at O(log n) by preventing the linked list situation from happening.
 * This specific implementation is an AVL tree. See https://en.wikipedia.org/wiki/AVL_tree for more information.
 *
 * The tree works by checking the height differences between the left and right branches of a node and
 * ensuring there isn't ever a difference of more than 1, if this difference was to arise,
 * it will rotate nodes around to ensure balance
 *
 * e.g.        becomes:
 *      a               b
 *       \            /   \
 *        b          a     c
 *         \
 *          c
 *
 * In testing this effiency improvement with 21,000 nodes over an average of 100 tests,
 * took the time to search for an item from roughly 80,000 nanoseconds to 140.
 * The testing wasn't in sterile condidtions but gives a rough real world demonstartion
 * of the improvement an AVL tree has in worst case scenarios compared to standards BST's.
 *
 * This class implements the individual nodes of the tree.
 */
public class BSTNodeSelfBalancing extends BSTNode {
    /*if balance factor is -1 or less then the node is left side heavy, 0 is balanced,
     and 1+ is right side heavy.
     level is what level of the tree a node is at, with a leaf being 1 and a root being larger
     */
    private int balanceFactor, level;

    /**
     * constructor for the node
     * @param elem the element being added
     */
    public BSTNodeSelfBalancing(Profile elem) {
        super(elem);
        this.balanceFactor = 0;
        this.level = 0;
    }

    /**
     * @return the left child node
     * This is an unsafe cast, but I don't want to interfere with my assignment code.
     */
    public BSTNodeSelfBalancing getL() {
        return (BSTNodeSelfBalancing) super.getL();
    }

    /**
     * @return the right child node
     */
    public BSTNodeSelfBalancing getR() {
        return (BSTNodeSelfBalancing) super.getR();
    }

    /**
     * @return the level within the tree that the node is at
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the balance factor of the node
     */
    public int getBalanceFactor() {
        return balanceFactor;
    }

    /**
     * balance factor works out if a node is heavier on the left or right, or if its balanced.
     * bf < 0 means left side heavy, bf == 0 means balanced, bf > 0 means right side heavy
     */
    public void setBalanceFactor() {
        if ((this.getR() != null) && (this.getL() != null)){
            this.balanceFactor = (this.getR().getLevel() - this.getL().getLevel());
        } else if ((this.getR() != null) && (this.getL() == null)) {
            this.balanceFactor = this.getR().getLevel();
        } else if ((this.getL() != null) && (this.getR() == null)) {
            this.balanceFactor = -this.getL().getLevel();
        } else {
            this.balanceFactor = 0;
        }
    }

    /**
     * calculates what level the node is in the tree,
     * where a leaf is 1 and level increments  by 1 going up the tree
     */
    public void setLevel() {
        if ((this.getL() == null) && (this.getR() == null)) {
            this.level = 1;
        } else if ((this.getR() != null) && (this.getL() == null)) {
            this.level = this.getR().getLevel() + 1;
        } else if ((this.getL() != null) && (this.getR() == null)) {
            this.level = this.getL().getLevel() + 1;
        } else {
            int l = this.getL().getLevel();
            int r = this.getR().getLevel();
            if ( l > r) {
                this.level = l + 1;
            } else if (r > l) {
                this.level = r + 1;
            } else {
                this.level = l + 1;
            }
        }
    }

    /**
     * @return the node as a string
     */
    @Override
    public String toString() {
        return  "{" + this.getLevel() + " " + this.getBalanceFactor() + " " + super.toString() + "}";
    }
}
