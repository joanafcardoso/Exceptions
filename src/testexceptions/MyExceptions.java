package testexceptions;

/**
 * Created by Cardoso on 27-Jan-16.
 */
public class MyExceptions {
    private static double averageScore( double totalScore , String noStudentsAsString) {
        int noStudents = Integer.parseInt(noStudentsAsString);
        double averageScore = (int) totalScore / noStudents;
        return averageScore;
    }

    public static void testAverages() {
        double s1 = averageScore(900, "10");
        System.out.println("Average score of (900,10) is " + s1);

        try {
            double s2 = averageScore(90, "oops");
            //System.out.println("Average score of (90,oops) is " + s2);//this gives failure of Number Format Exception
        } catch (NumberFormatException s2) {
            System.out.println("Average score of (90,oops) is a Number Format Exception");
        }

        try {
            double s3 = averageScore(90, "0");
            System.out.println("Average score of (90,0) is " + s3);//this gives Infinity. double or float numbers
            // divided by 0 return Infinity, to return ArithmeticException / by zero, they need to be of type int
        } catch (ArithmeticException s) {
            System.out.println("Average score of (90,0) is an Arithmetic Exception");
        }
    }

    public static void main (String[]args){
        testAverages();
    }
}
