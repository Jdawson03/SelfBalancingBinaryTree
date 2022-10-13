import java.util.ArrayList;

/**
 * @version 1.0.0
 * @author Joseph Dawson
 * This class creates and contains the methods needed for creating a Binary Search Tree (BST),
 * and then using it afterwards.
 */
public class BST {
    //The root of the tree.
    private BSTNode root;

    /**
     * Creates a blank binary tree.
     */
    public BST() {
        this.root = null;
    }

    /**
     * A class to add researchers to the BST.
     * @param p new researcher Profile to add to the BST
     */
    public void insertResearcher(Profile p) {
        BSTNode n = new BSTNode(p);
        if (this.root == null) {
            this.root = n;
        } else {
            addNode(n, this.root);
        }
    }

    /**
     * recursively traverses the tree until it's in the appropriate place to insert a new node.
     * @param childN the node to add to the tree
     * @param parentN the current node being checked and
     *                the potential parent node if child is placed in this recursion
     * @return the new BSTNode in the BST.
     */
    private BSTNode addNode(BSTNode childN, BSTNode parentN) {
        if (childN.getResearcher().getFamilyNames().compareTo(
                parentN.getResearcher().getFamilyNames()) < 0) {
            if (parentN.getL() == null) {
                parentN.setL(childN);
            } else {
                addNode(childN, parentN.getL());
            }

        } else if (childN.getResearcher().getFamilyNames().compareTo(
                parentN.getResearcher().getFamilyNames()) > 0) {
            if (parentN.getR() == null) {
                parentN.setR(childN);
            } else {
                addNode(childN, parentN.getR());
            }
        }
        return childN;
    }

    /**
     * returns the names of the researchers in the tree to print out in the main class.
     * @return a formatted string of names to print out.
     */
    public String printAlphabetical() {
        ArrayList<String> namesOfResearchers = new ArrayList<>();
        String output = "";
        for (String s : printAlphabetical(this.root, namesOfResearchers)) {
            output = output.concat(s + "\n");
        }
        return output;
    }

    /**
     * creates an ArrayList of researcher names to be returned for formatting and outputting.
     * In-Order traversal
     * @param n the current node being visited
     * @param namesOfResearchers list of reasearchers in alphabetical order
     * @return
     */
    private ArrayList<String> printAlphabetical(BSTNode n, ArrayList<String> namesOfResearchers) {
        if (n.getL() != null)
            printAlphabetical(n.getL(), namesOfResearchers);
        //if returns void instead you can replace the below line with a print statement
        //and remove the need for an arrayList
        namesOfResearchers.add(n.getResearcher().getFamilyNames() + ", " + n.getResearcher().getGivenNames());
        if (n.getR() != null)
            printAlphabetical(n.getR(), namesOfResearchers);
        return namesOfResearchers;
    }

    /**
     * find a researcher in the tree based on surname
     * @param familyName the family name being looked for.
     * @return the profile being searched for.
     */
    public Profile search(String familyName) {
        return search(this.root, familyName);
    }

    /**
     * pre-order traversal of the tree to find a specific person
     * @param root node of the tree currently being examined
     * @param familyName being searched for
     * @return the profile being looked for
     */
    private Profile search(BSTNode root, String familyName) {
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
     * @return the tree as a string
     */
    @Override
    public String toString() {
        return "BST{" +
                "root=" + root;
    }

    /**
     * Returns an ArrayList of all the profiles in the tree in alphabetical order.
     * a not very elegant solution to part2 of Stage6 since it creates a 2nd data structure
     * removing the benefits of the BST. However, since the BST isn't sorted by collaborators,
     * the benefits of the BST are lost.
     * @return the entire contents of the tree as an alphabetical array
     */
    public ArrayList<Profile> getArrayOfAllTreeContents() {
        return getArrayOfAllTreeContents(this.root, new ArrayList<>());
    }

    /**
     * creates the ArrayList of all Profiles in the tree. In-Order Traversal
     * @param n current node being taken
     * @param lstOfProfiles the list of all the profiles in Alphabetical order
     * @return a complete list of all the profiles.
     */
    private ArrayList<Profile> getArrayOfAllTreeContents(BSTNode n, ArrayList<Profile> lstOfProfiles) {
        if (n.getL() != null)
            getArrayOfAllTreeContents(n.getL(), lstOfProfiles);
        lstOfProfiles.add(n.getResearcher());
        if (n.getR() != null)
            getArrayOfAllTreeContents(n.getR(), lstOfProfiles);
        return lstOfProfiles;
    }

}


