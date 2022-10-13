import java.util.ArrayList;

public class SpecificTest {
  public static void main(String[] args) {
    // each test is designed to check a specific type of rotation being implemented.
/*
    //Left Rotation
    Profile pers1 = new Profile( "asfd", "Alpha", 1231, 23, 43,"asd", new ArrayList<>());
    Profile pers2 = new Profile( "ewrfsd", "Banana", 1231, 23, 43, "asd",new ArrayList<>());
    Profile pers3 = new Profile( "fsdsdgv", "Cranberry", 1231, 23, 43, "asd",new ArrayList<>());


    BST tree = new BST();
    tree.insertResearcher(pers1);
    //  System.out.println("\n");
    //  tree.printAlphabetical();
    tree.insertResearcher(pers2);
    //  System.out.println("\n");
    //  tree.printAlphabetical();
    tree.insertResearcher(pers3);

    System.out.println(tree);


    //Right Rotation
    Profile pers4 = new Profile( "asfd", "Alpha", 1231, 23, 43,"asd", new ArrayList<>());
    Profile pers5 = new Profile( "ewrfsd", "Banana", 1231, 23, 43, "asd",new ArrayList<>());
    Profile pers6 = new Profile( "fsdsdgv", "Cranberry", 1231, 23, 43, "asd",new ArrayList<>());


    BST tree1 = new BST();
    tree1.insertResearcher(pers6);
    //  System.out.println("\n");
    //  tree.printAlphabetical();
    tree1.insertResearcher(pers5);
    //  System.out.println("\n");
    //  tree.printAlphabetical();
    tree1.insertResearcher(pers4);

    System.out.println(tree1);


    //Double Left Rotation
    Profile pers7 = new Profile( "asfd", "Alpha", 1231, 23, 43,"asd", new ArrayList<>());
    Profile pers8 = new Profile( "ewrfsd", "Banana", 1231, 23, 43, "asd",new ArrayList<>());
    Profile pers9 = new Profile( "fsdsdgv", "Cranberry", 1231, 23, 43, "asd",new ArrayList<>());

    BST tree2 = new BST();
    tree2.insertResearcher(pers7);
    //  System.out.println("\n");
    //  tree.printAlphabetical();
    tree2.insertResearcher(pers9);
    //  System.out.println("\n");
    //  tree.printAlphabetical();
    tree2.insertResearcher(pers8);

    System.out.println(tree2);

 */

    //Double Right Rotation
    Profile pers10 = new Profile( "asfd", "Alpha", 1231, 23, 43,"asd", new ArrayList<>());
    Profile pers11 = new Profile( "ewrfsd", "Banana", 1231, 23, 43, "asd",new ArrayList<>());
    Profile pers12 = new Profile( "fsdsdgv", "Cranberry", 1231, 23, 43, "asd",new ArrayList<>());

    BST tree3 = new BST();
    tree3.insertResearcher(pers12);
    //  System.out.println("\n");
    //  tree.printAlphabetical();
    tree3.insertResearcher(pers10);
    //  System.out.println("\n");
    //  tree.printAlphabetical();
    tree3.insertResearcher(pers11);

    System.out.println();
    System.out.println(tree3);
  }
}
