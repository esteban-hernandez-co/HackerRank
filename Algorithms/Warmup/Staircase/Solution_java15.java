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
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
    // Write your code here
        int numberSpace = 0;
        int numberStair = 0;
        for(int level = n; level > 0; level--){
            numberSpace = level - 1;
            numberStair = n - (level - 1);
            
            System.out.print(" ".repeat(numberSpace));
            System.out.println("#".repeat(numberStair));
            //System.out.println(String.format("level %d spaces = %d", numberStair, numberSpace));
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
