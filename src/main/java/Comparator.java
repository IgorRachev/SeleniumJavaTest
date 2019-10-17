


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Comparator  {
    //TODO: for normal work uncomment 2 rows below and comment next two
//    int attemptValue = this.getIntFromConsole();
//    String sAttemptValue = Integer.toString(this.attemptValue);
    String sAttemptValue = "";
    int attemptValue = 1;
    public int testAttemptValue;

    //TODO: for normal work uncomment method below
    /**
     * Gets value from console
     * @return no outputs
     */
//    public int getIntFromConsole(){
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter your 4-digits number: ");
//        try {
//            return Integer.parseInt(reader.readLine());
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            attemptValue = this.getIntFromConsole();
//        }
//        return attemptValue;
//    }

    /**
     *
     * @param a - random string value from 0 to 9999 generates by system
     * @return number of Bulls -  equal values, placed onto correct position
     */

    public int getBulls(String a){
        int n = 0;
        for (int i=0; i<sAttemptValue.length(); i++){
            if(sAttemptValue.charAt(i) == a.charAt(i) ){
                n = n + 1;
            }
        }
        return n;
    }

    /**
     *
     * @param a - random string value from 0 to 9999 generates by system
     * @return number of Cows - values are equal, but not placed onto correct position
     */
    public int getCows(String a){
        int c = 0;
        for (int i=0; i<sAttemptValue.length(); i++)
            if (sAttemptValue.charAt(i) != a.charAt(i) & a.contains("" + sAttemptValue.charAt(i))) {
                c = c + 1;
            }
        return c;
    }


    public String setTestAttemptValue(int testAttemptValue) {
        return sAttemptValue = String.valueOf(testAttemptValue);
    }
}