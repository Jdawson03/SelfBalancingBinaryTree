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
 */
//any duplicated code between this class and BST is to prevent complications with my assignment
public class BSTSelfBalancing {
    //root node of tree
    private BSTNodeSelfBalancing root;

    /**
     * initialises the tree
     */
    public BSTSelfBalancing() {
        this.root = null;
    }

    /**
     * adds a new researcher to the tree
     * @param p the new researcher to be added
     */
    public void insertResearcher(Profile p) {
        BSTNodeSelfBalancing n = new BSTNodeSelfBalancing(p);
        if (this.root == null) {
            this.root = n;
        } else {
            this.root = addNode(this.root, n);
        }
    }

    /**
     * adds a new node to the tree and then triggers the balance checks
     * @param parentN the parent node being examined
     * @param childN the child node to add to the tree
     * @return returns a node stored in the tree
     */
    private BSTNodeSelfBalancing addNode(BSTNodeSelfBalancing parentN, BSTNodeSelfBalancing childN) {
        if (parentN == null) {
            return childN;
        } else if (parentN.getResearcher().getFamilyNames().compareTo(
                childN.getResearcher().getFamilyNames()) > 0) {
            parentN.setL(addNode(parentN.getL(), childN));
        } else if (parentN.getResearcher().getFamilyNames().compareTo(
                childN.getResearcher().getFamilyNames()) < 0) {
            parentN.setR(addNode(parentN.getR(), childN));
        }
        return rebalance(parentN);
    }


    /**
     * @param n the node to check
     * @return the level the node is at, or -1 if it is empty
     */
    private int nullSafeGetLevel(BSTNodeSelfBalancing n) {
        if (n == null) {
            return -1;
        } else {
            return n.getLevel();
        }
    }

    /**
     * checks the tree remains balanced by updating what level nodes are at
     * and seeing if any rotations are needed
     * @param z the node being balanced
     * @return a balanced node
     */
    private BSTNodeSelfBalancing rebalance(BSTNodeSelfBalancing z) {
        z.setLevel();
        z.setBalanceFactor();
        if (z.getBalanceFactor() > 1) {
            if (nullSafeGetLevel(z.getR().getR()) > nullSafeGetLevel(z.getR().getL())) {
                z = rotateLeft(z);
            } else {
                z = doubleRotateLeft(z);
            }
        } else if (z.getBalanceFactor() < -1) {
            if (nullSafeGetLevel(z.getL().getL()) > nullSafeGetLevel(z.getL().getR())) {
                z = rotateRight(z);
            } else {
                z = doubleRotateRight(z);
            }
        }
        return z;
    }

    /**         becomes:
     *  a                 b
     *   \              /  \
     *    b            a    c
     *     \
     *      c
     * @param rt root, the node being balanced
     * @return the new parent node
     */
    private BSTNodeSelfBalancing rotateLeft(BSTNodeSelfBalancing rt)  {
        BSTNodeSelfBalancing x =  rt.getR();
        BSTNodeSelfBalancing rt2 = x.getL();
        x.setL(rt);
        rt.setR(rt2);
        rt.setLevel();
        x.setLevel();
        rt.setBalanceFactor();
        x.setBalanceFactor();
        return x;
    }

    /**           becomes:
     *         c            b
     *       /            /  \
     *      b            a    c
     *    /
     *   a
     * @param rt root, the node being balanced
     * @return the balanced nodes, returning the new parent node.
     */
    private BSTNodeSelfBalancing rotateRight(BSTNodeSelfBalancing rt) {
        BSTNodeSelfBalancing y = rt.getL();
        BSTNodeSelfBalancing rt2 = y.getR();
        y.setR(rt);
        rt.setL(rt2);
        rt.setLevel();
        y.setLevel();
        rt.setBalanceFactor();
        y.setBalanceFactor();
        return y;
    }

    /**           becomes:
     *      c                 b
     *     /                /   \
     *    a                a     c
     *     \
     *      b
     * due to the complexity of the arrangement, a double rotation is needed to create balance,
     * since just one rotation would only swap b and a meaning C as the root still wouldn't be balanced.
     * @param z the node being balanced
     * @return the new parent node
     */
    private BSTNodeSelfBalancing doubleRotateRight(BSTNodeSelfBalancing z)  {
        z.setL(rotateLeft(z.getL()));
        z = rotateRight(z);
        return z;
    }

    /**           becomes:
     *     a                b
     *      \             /  \
     *       c           a    c
     *      /
     *     b
     *
     * due to the complexity of the arrangement, a double rotation is needed to create balance,
     * since just one rotation would only swap c and b meaning A as the root still wouldn't be balanced.
     * @param z the node being balanced
     * @return the new parent node
     */
    private BSTNodeSelfBalancing doubleRotateLeft(BSTNodeSelfBalancing z)  {
        z.setR(rotateRight(z.getR()));
        z = rotateLeft(z);
        return z;
    }

    /**
     * starts the process to print all the names in the tree alphabetically.
     */
    public void printAlphabetical() {
        printAlphabetical(this.root);
    }

    /**
     * in order traversal of the AVL tree, to directly print out the family names of all researchers in the tree.
     * @param n the node currently visited
     */
    private void printAlphabetical(BSTNodeSelfBalancing n) {
        if (n.getL() != null)
            printAlphabetical (n.getL());
        System.out.println(n.getResearcher().getFamilyNames());
        if (n.getR() != null)
            printAlphabetical(n.getR());
    }

    /**
     * method to find the profile or a specific researcher
     * @param familyName the person being searched for
     * @return the profile of the name being looked for
     */
    public Profile search(String familyName) {
        return search(this.root, familyName);
    }

    /**
     * recursively search through the tree in pre-order
     * @param root the current node being checked
     * @param familyName the name being looked for
     * @return the profile of the person being searched for
     */
    private Profile search(BSTNodeSelfBalancing root, String familyName) {
        if (root == null) {
            return null;
        } else if (root.getResearcher().getFamilyNames().equals(familyName)) {
            return root.getResearcher();
        } else if (root.getResearcher().getFamilyNames().compareTo(familyName) > 0 ) {
            return search(root.getL(), familyName);
        }
        return search(root.getR(), familyName);
    }

    /**
     * @return the entire tree structure and researcher names as a string
     */
    @Override
    public String toString() {
        return "BST{" +
                "root=" + root;
    }
}
