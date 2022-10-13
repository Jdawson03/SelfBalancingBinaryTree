import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Not my code. It was provided to me as a way to test the amount of time the different trees take to traverse.
 * although the commenting was added by me
 */
public class TimeTestMain {
    public static void main(String[] args) {

        //Swap with BST and BSTSelfBalancing here for different test cases
        BSTSelfBalancing tree = new BSTSelfBalancing();

        ArrayList<String> interests = new ArrayList<>();
        //Change i to change the number of items in the tree
        //items are added in reverse order to create a worst case scenario of linked list
        for (int i = 21000; i > 0; i--) {
            String givenName = String.valueOf(i);
            String familyName = String.valueOf(i);
            String email = String.valueOf(i);
            tree.insertResearcher(new Profile(givenName, familyName, i,i,i, email, interests));
        }

        //change the number value to change how many times the test is performed to average out the result from
        long[] average = new long[100];
        for (int i = 0; i < 100; i++) {

            /*random data item chosen to simulate time taken to find it.
              A number out of range of the elements in the tree will take the total depth of the tree to find
              meaning the deeper the tree, the longer it'll take to return the fact that the item wasn't found.
             */
            long nanosecondTimeTaken = ITimeMethods.timeComputation(()->tree.search("280000"));

           // System.out.printf("Method took APPROX %dns each time \n", nanosecondTimeTaken);
            average[i] = nanosecondTimeTaken;
        }

        //calculates the average amount of time taken over the number of tests.
        long total = 0;
        for (long num: average) {
            total = total + num;
        }
        total = total / average.length;
        System.out.printf("total time taken is %d \n", total );

        System.out.println(ITimeMethods.timeComputation(1000, 10000, ()->tree.search("1237")));




    }

}
