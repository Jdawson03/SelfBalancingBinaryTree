import java.util.ArrayList;

public class GraphMain {
    public static void main(String[] args) {
        Profile persa = new Profile( "a", "a", 1231, 23, 43,"asd", new ArrayList<>());
        Profile persb = new Profile( "b", "b", 1231, 23, 43, "asd",new ArrayList<>());
        Profile persc = new Profile( "c", "c", 1231, 23, 43, "asd",new ArrayList<>());
        Profile persd = new Profile( "d",  "d",1231, 23, 43, "asd", new ArrayList<>());
        Profile perse = new Profile("e", "e",  1231, 23, 43,"asd", new ArrayList<>());
        Profile persf = new Profile( "f","f",  1231, 23, 43,"asd", new ArrayList<>());
        Profile persg = new Profile( "g", "g", 1231, 23, 43, "asd", new ArrayList<>());
        Profile persh = new Profile( "h", "h", 1231, 23, 43,"asd", new ArrayList<>());
        Profile persi = new Profile( "i", "i", 1231, 23, 43,"asd", new ArrayList<>());
        Profile persj = new Profile( "j", "j",  1231, 23, 43,"asd", new ArrayList<>());
       // Profile pers11 = new Profile( "hfghf", "Merry", 1231, 23, 43,"asd", new ArrayList<>());
        Profile persk = new Profile( "k", "k", 1231, 23, 43,"asd", new ArrayList<>());
        Profile persl = new Profile( "l", "l", 1231, 23, 43, "asd",new ArrayList<>());
        Profile persm = new Profile( "m", "m", 1231, 23, 43, "asd",new ArrayList<>());
        Profile persn = new Profile( "n",  "n",1231, 23, 43, "asd", new ArrayList<>());
        Profile perso = new Profile("o", "o",  1231, 23, 43,"asd", new ArrayList<>());
        Profile persp = new Profile( "p","p",  1231, 23, 43,"asd", new ArrayList<>());
        Profile persq = new Profile( "q", "q", 1231, 23, 43, "asd", new ArrayList<>());
        Profile persr = new Profile( "r", "r", 1231, 23, 43,"asd", new ArrayList<>());
        Profile perss = new Profile( "s", "s", 1231, 23, 43,"asd", new ArrayList<>());
        //Profile pers21 = new Profile( "rty", "James",  1231, 23, 43,"asd", new ArrayList<>());
        //Profile pers22 = new Profile( "hfghf", "Merry", 1231, 23, 43,"asd", new ArrayList<>());



        BST tree = new BST();


        tree.insertResearcher(persl);
        tree.insertResearcher(persa);
        tree.insertResearcher(persm);
        tree.insertResearcher(persn);
        tree.insertResearcher(persb);
        tree.insertResearcher(persq);
        tree.insertResearcher(persc);
        tree.insertResearcher(persd);
        tree.insertResearcher(perse);
        tree.insertResearcher(perso);
        tree.insertResearcher(persp);
        tree.insertResearcher(persr);
        tree.insertResearcher(persf);
        tree.insertResearcher(persg);
        tree.insertResearcher(persj);
        tree.insertResearcher(persi);
        tree.insertResearcher(persk);
        tree.insertResearcher(perss);
        tree.insertResearcher(persh);
        //System.out.println(tree.printAlphabetical());

        Graph aGraph = new Graph("edges.txt", tree);

        System.out.println(persa);
        System.out.println(persb);
        System.out.println(persc);
        System.out.println(persd);
        System.out.println(perse);
        System.out.println(persi);
        System.out.println(persl);

        System.out.println("potential influencers: ");

//expected outcome c
        System.out.println(aGraph.findInfluencer(perse.getFamilyNames()));
//expected outcome d
        System.out.println(aGraph.findInfluencer(persa.getFamilyNames()));



    }
}
