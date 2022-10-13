import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @version 1.0.0
 * @author Joseph Dawson
 * The individual Profile of a researcher in the network.
 */
public class Profile {
    //the attributes for each researcher in their profile.
    private String familyNames, givenNames, email;
    private int yearPhD, monthPhD, dayPhD;
    private ArrayList<String> researchInts;
    private HashSet<Profile> collaborators;

    /**
     * creates the Profile of a researcher
     * @param givenNames the researchers given names
     * @param familyNames the researchers surname names
     * @param yearPhD the year the researcher earned their phD
     * @param monthPhD the month the researcher earned their phD
     * @param dayPhD the day the researcher earned their phD
     * @param email the researchers email address
     * @param researchInts the interests of the researcher
     */
    public Profile (String familyNames, String givenNames, int yearPhD, int monthPhD, int dayPhD,
                    String email, ArrayList<String> researchInts) {
        this.givenNames = givenNames;
        this.familyNames = familyNames;
        this.email = email;
        this.yearPhD = yearPhD;
        this.monthPhD = monthPhD;
        this.dayPhD = dayPhD;
        this.researchInts = researchInts;
        this.collaborators = new HashSet<Profile>();

    }

    /**
     * @return the full name of the researcher
     */
    public String getName() {
        return givenNames + " " + familyNames;
    }

    /**
     * @return the surname of the researcher
     */
    public String getFamilyNames() {
        return familyNames;
    }

    /**
     * sets a new family name for the researcher
     * @param familyNames researchers family name
     */
    public void setFamilyNames(String familyNames) {
        this.familyNames = familyNames;
    }

    /**
     * @return the given name of the researcher
     */
    public String getGivenNames() {
        return givenNames;
    }

    /**
     * sets a new given name for the researcher
     * @param givenNames researchers given name
     */
    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    /**
     * @return the email address of the researcher
     */
    public String getEmail() {
        return email;
    }

    /**
     * resets the researchers email address
     * @param email researchers email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the year the researcher earned their phD
     */
    public int getYearPhD() {
        return yearPhD;
    }

    /**
     * @param yearPhD reset the year
     */
    public void setYearPhD(int yearPhD) {
        this.yearPhD = yearPhD;
    }

    /**
     * @return the month the researcher earned their phD
     */
    public int getMonthPhD() {
        return monthPhD;
    }

    /**
     * @param monthPhD reset the month
     */
    public void setMonthPhD(int monthPhD) {
        this.monthPhD = monthPhD;
    }

    /**
     * @return the day the researcher earned their phD
     */
    public int getDayPhD() {
        return dayPhD;
    }

    /**
     * @param dayPhD reset the day the researcher earned their phD
     */
    public void setDayPhD(int dayPhD) {
        this.dayPhD = dayPhD;
    }

    /**
     * @return the list of research interests
     */
    public ArrayList<String> getResearchInts() {
        return researchInts;
    }

    /**
     * @param researchInts resets the list of research interests
     */
    public void setResearchInts(ArrayList<String> researchInts) {
        this.researchInts = researchInts;
    }

    /**
     *
     * @return date the phD was earned
     */
    public String getDateOfPhD() {
        return String.format("%04d", getYearPhD()) + "-"
                + String.format("%02d", getMonthPhD()) + "-"
                + String.format("%02d", getDayPhD());

        /*
        if (getMonthPhD() < 10 && getDayPhD() < 10) {
            return getYearPhD() + "-" + "0" + getMonthPhD() + "-" + "0" + getDayPhD();
        } else if (getMonthPhD() < 10 ) {
            return getYearPhD() + "-" + "0" + getMonthPhD() + "-" + getDayPhD();
        } else if (getDayPhD() < 10) {
            return getYearPhD() + "-" + getMonthPhD() + "-" + "0" + getDayPhD();
        } else {
            return getYearPhD() + "-" + getMonthPhD() + "-" + getDayPhD();
        }

         */
    }

    /**
     * add a new item to the list of collaborators in both directions
     * @param p a new profile collaborated with
     */
    public void collaborate (Profile p) {
        collaborators.add(p);
        p.collaborators.add(this);
    }

    /**
     * @param p the profile to check if they have collaborated with this
     * @return boolean based on if p has worked with this before
     */
    public boolean hasCollaboratedWith (Profile p) {
        return collaborators.contains(p);
    }

    /**
     * @return how many people have been collaborated with
     */
    public int numOfCollabs() {
        return collaborators.size();
    }

    /**
     * @return a string of family names of everyone collaborated with
     */
    public ArrayList<String> toStringCollabs() {
        ArrayList<String> familyNamesCollabed = new ArrayList<>();
        for (Profile pro : this.collaborators) {
            familyNamesCollabed.add(pro.getFamilyNames());
        }
        return familyNamesCollabed;
    }

    /**
     * @return a profile as a string
     */
    @Override
    public String toString() {
        return "Profile{" +
                "familyNames='" + familyNames + '\'' +
                ", givenNames='" + givenNames + '\'' +
                ", email='" + email + '\'' +
                ", yearPhD=" + yearPhD +
                ", monthPhD=" + monthPhD +
                ", datePhD=" + getDateOfPhD() + //because day isnt asked for, date is instead.
                ", researchInts=" + researchInts +
                ", collaborators=" + toStringCollabs() +
                '}';
    }

}
