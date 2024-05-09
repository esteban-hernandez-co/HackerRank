import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
    // Write your code here
        //256th day of the year
        //(September 13 during common years and on September 12 in leap years).
        //1918 14th of Feb was the 32nd day
        String returnString = "%s.09.%s";
        
        if(year < 1700 || year > 2700) return "invalid";
        
        if(year < 1918){
            //leap year?
            if(year % 4 == 0){
                return String.format(returnString, 12,year);
            }else{
                return String.format(returnString, 13,year);
            }
        }
        
        if(year == 1918){
            return String.format(returnString, 26,year);
        }else{
            //leap year?
            if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                return String.format(returnString, 12,year);
            }else{
                return String.format(returnString, 13,year);
            }
        }
        
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
