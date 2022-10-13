import java.util.ArrayList;

public class ProfileMain {
    public static void main(String[] args) {
        Profile pers1 = new Profile("ah", "asd",
                2222, 43, 12,"asdff", new ArrayList<>());
        Profile pers2 = new Profile("bah", "efdas",
                2100, 21, 90, "qwefdz",new ArrayList<>());
        Profile pers3 = new Profile("ah", "asd",
                2222, 43, 12, "asdff", new ArrayList<>());


        System.out.println(pers1);
        pers1.collaborate(pers2);
        pers1.collaborate(pers3);
        System.out.println(pers1.hasCollaboratedWith(pers2));
        System.out.println(pers2.hasCollaboratedWith(pers1));
        System.out.println(pers3.hasCollaboratedWith(pers1));
        System.out.println(pers1.numOfCollabs());
        System.out.println(pers3.numOfCollabs());
        pers2.collaborate(pers3);
        pers2.collaborate(pers3);
        System.out.println(pers2.numOfCollabs());
        System.out.println(pers3.numOfCollabs());
        System.out.println(pers1.hasCollaboratedWith(pers2));
        System.out.println(pers1);

        Profile datePers1 = new Profile("date", "date",
                22, 1,1,"ah", new ArrayList<>());

        System.out.println(datePers1.getDateOfPhD());
    }
}
