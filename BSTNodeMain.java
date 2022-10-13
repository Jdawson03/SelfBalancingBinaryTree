import java.util.ArrayList;

public class BSTNodeMain {
    public static void main(String[] args) {
        Profile pers1 = new Profile( "asfd", "Merry", 1231, 23, 43,"asd", new ArrayList<>());
        Profile pers2 = new Profile( "ewrfsd", "Banana", 1231, 23, 43, "asd",new ArrayList<>());
        Profile pers3 = new Profile( "fsdsdgv", "Cranberry", 1231, 23, 43, "asd",new ArrayList<>());
        Profile pers4 = new Profile( "ewrfgfg",  "Zebra",1231, 23, 43, "asd", new ArrayList<>());
        Profile pers5 = new Profile("dynamo", "Lemon",  1231, 23, 43,"asd", new ArrayList<>());
        Profile pers6 = new Profile( "jhkhjk","Giraffe",  1231, 23, 43,"asd", new ArrayList<>());
        Profile pers7 = new Profile( "tyrygh", "Avocado", 1231, 23, 43, "asd", new ArrayList<>());
        Profile pers8 = new Profile( "iopui", "Muppet", 1231, 23, 43,"asd", new ArrayList<>());
        Profile pers9 = new Profile( "bvngv", "James", 1231, 23, 43,"asd", new ArrayList<>());
        Profile pers10 = new Profile( "rty", "Zzzz",  1231, 23, 43,"asd", new ArrayList<>());
        Profile pers11 = new Profile( "hfghf", "Merry", 1231, 23, 43,"asd", new ArrayList<>());
        Profile pers12 = new Profile( "asfd", "Daniel", 1231, 23, 43,"asd", new ArrayList<>());
        Profile pers13 = new Profile( "ewrfsd", "Elmo", 1231, 23, 43, "asd",new ArrayList<>());
        Profile pers14 = new Profile( "fsdsdgv", "Eabo", 1231, 23, 43, "asd",new ArrayList<>());
        Profile pers15 = new Profile( "ewrfgfg",  "Aardvark",1231, 23, 43, "asd", new ArrayList<>());
        Profile pers16 = new Profile("dynamo", "Frances",  1231, 23, 43,"asd", new ArrayList<>());
        Profile pers17 = new Profile( "jhkhjk","Hello",  1231, 23, 43,"asd", new ArrayList<>());
        Profile pers18 = new Profile( "tyrygh", "Igloo", 1231, 23, 43, "asd", new ArrayList<>());
        Profile pers19 = new Profile( "iopui", "Joe", 1231, 23, 43,"asd", new ArrayList<>());
        Profile pers20 = new Profile( "bvngv", "Katherine", 1231, 23, 43,"asd", new ArrayList<>());
        Profile pers21 = new Profile( "rty", "James",  1231, 23, 43,"asd", new ArrayList<>());
        Profile pers22 = new Profile( "hfghf", "Merry", 1231, 23, 43,"asd", new ArrayList<>());


        BSTSelfBalancing tree = new BSTSelfBalancing();

        tree.insertResearcher(pers1);
        tree.insertResearcher(pers2);
        tree.insertResearcher(pers3);
        tree.insertResearcher(pers4);
        tree.insertResearcher(pers5);
        tree.insertResearcher(pers6);
        tree.insertResearcher(pers7);
        tree.insertResearcher(pers8);
        tree.insertResearcher(pers9);
        tree.insertResearcher(pers10);
        tree.insertResearcher(pers11);
        tree.insertResearcher(pers12);
        tree.insertResearcher(pers13);
        tree.insertResearcher(pers14);
        tree.insertResearcher(pers15);
        tree.insertResearcher(pers16);
        tree.insertResearcher(pers17);
        tree.insertResearcher(pers18);
        tree.insertResearcher(pers19);
        tree.insertResearcher(pers20);
        tree.insertResearcher(pers21);
        tree.insertResearcher(pers22);


/*
        for (int i = 500; i > 0; i--) {
            String givenName = String.valueOf(i);
            String familyName = String.valueOf(i);
            String email = String.valueOf(i);
            tree.insertResearcher(new Profile(givenName, familyName, i,i,i, email, new ArrayList<>()));

        }

 */

        tree.printAlphabetical();


        //System.out.println(tree);
        //System.out.print("we found" );
        //System.out.println(tree.search("37").getFamilyNames());

    }
}
