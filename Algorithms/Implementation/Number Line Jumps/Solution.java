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
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
    // Write your code here
        boolean firstStep = true;
        int jumpx1 = 0;
        int jumpx2 = 0;
        int count = 0;
        if((x1 > x2) && (v1 >= v2)){
            return "NO";
        }else
            if((x2 >= x1) && (v2 >= v1)){
                return "NO";
            }else{
                
                while(true){
                    if(firstStep){
                        jumpx1 = x1 + v1;
                        jumpx2 = x2 + v2; 
                        firstStep = false;   
                    }else{
                        jumpx1 += v1;
                        jumpx2 += v2;
                    }
                    if(jumpx1 == jumpx2){
                        return "YES";
                    }
                    if(count > 10000){
                        return "NO";
                    }
                    count++;
                    
                }
            }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
