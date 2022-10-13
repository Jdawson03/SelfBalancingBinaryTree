import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0.0
 * @author Joseph Dawson
 *
 * Reads in a text File to create new Researcher profiles and add them to a BST.
 */
public class FileReader {
    /**
     * ensures the file can be found ready to be read.
     * @param filename the name of the file to be read
     * @return a complete BST based on the input file
     */
    public static BST readResearcherProfiles (String filename) {
        File f = new File(filename); // + ".txt"
        Scanner in = null;
        try {
            in = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + filename);
            System.exit(0);
            //e.printStackTrace();
        }
        return FileReader.readAndAddLineByLine(in);
    }

    /**
     * creates the tree and adds a profile at a time to it.
     * @param in the scanner to read the text file
     * @return a complete tree of profiles
     */
    private static BST readAndAddLineByLine (Scanner in) {
        BST aTree = new BST();
        while (in.hasNextLine()) {
            String p = in.nextLine();
            aTree.insertResearcher(stringToProfile(p));
        }
        in.close();

        return aTree;
    }

    /**
     * takes a line from a file and interprets and returns it as a researcher profile.
     * @param s the line from the file as a string
     * @return a researcher profile defined by S
     */
    private static Profile stringToProfile(String s) {
        String[] sArray = s.split(",");
        //<Given Names>,<FamilyNames>,<DD-MM-YYYY>,<email>,<interest1>/<interest 2>/.../<interest n>
        String[] PhDDate = sArray[2].split("-");
        String[] interestArray = sArray[4].split("/");
        ArrayList<String> interests = new ArrayList<String>(Arrays.asList(interestArray));

        return new Profile(sArray[1], sArray[0],
                Integer.parseInt(PhDDate[0]), Integer.parseInt(PhDDate[1]), Integer.parseInt(PhDDate[2]),
                sArray[3], interests);
    }





}
