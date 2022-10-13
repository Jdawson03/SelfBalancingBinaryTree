public class FileReaderMain {
    public static void main(String[] args) {
        String filename = "researchers.txt";

        BST tree = FileReader.readResearcherProfiles(filename);
        System.out.println(tree);


        System.out.println(tree.printAlphabetical());


    }
}
