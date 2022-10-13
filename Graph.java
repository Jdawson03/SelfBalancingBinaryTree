import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version 1.0.0
 * @author Joseph Dawson
 *
 * Reads a textfile to implement who collaborated with who
 * and find influencers within the tree network.
 */
public class Graph {
    //a BST tree passed in to apply the collaborations too
    private BST tree;


    /**
     * creates the graph of collaborations
     * @param fileName the name of the file to read
     * @param tree the tree network of people being passed in
     */
    public Graph(String fileName, BST tree) {
        this.tree = tree;
        File f = new File(fileName);
        Scanner in = null;
        try {
            in = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + fileName);
            System.exit(0);
            //e.printStackTrace();
        }
        readAndAddLineByLine(in, tree);
    }

    /**
     * reads the file line at a time
     * @param in the file scanner
     * @param aTree the tree being add
     */
    private static void readAndAddLineByLine (Scanner in, BST aTree) {
        while (in.hasNextLine()) {
            String p = in.nextLine();
            stringToCollaboration(p, aTree);
        }
        in.close();
    }

    /**
     * reads the names of the collaborations and applies them if possible
     * @param s a line from the file
     * @param aTree the BST tree to apply the graph too
     */
    private static void stringToCollaboration (String s, BST aTree) {
        String[] sArray = s.split(",");
        Profile firstPers = aTree.search(sArray[0]);
        Profile secondPers = aTree.search(sArray[1]);
        if (firstPers != null && secondPers != null) {
            firstPers.collaborate(secondPers);
            secondPers.collaborate(firstPers);
        } else {
            System.out.println("person not found!");
        }
    }


    /**
     * finds the profile of a given researcher and then an appropriate influencer.
     * @param familyName the researcher trying to find an influencer
     * @return the profile of an appropriate influencer
     */
    public Profile findInfluencer (String familyName) {
        Profile startPers = this.tree.search(familyName);
        ArrayList<Profile> arrayOfPeople = this.tree.getArrayOfAllTreeContents();
        //a blank template to be replaced
        Profile blankProfile = new Profile("","",0,0,0,"", new ArrayList<>());
        Profile potentialInfluencer = blankProfile;
        for (Profile prof : arrayOfPeople) {
            if (prof.numOfCollabs() > potentialInfluencer.numOfCollabs()
                    && !startPers.hasCollaboratedWith(prof)
                    && !startPers.equals(prof))  {
                potentialInfluencer = prof;
            }
        }
        if (potentialInfluencer.equals(blankProfile)) {
            potentialInfluencer = startPers;
        }
        return potentialInfluencer;
    }



}
