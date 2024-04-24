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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        
        double positiveValue = 0.0;
        double negativeValue = 0.0;
        double zeroValue = 0.0;
        
        int numberPositiveValue = 0;
        int numberNegativeValue = 0;
        int numberZeroValue = 0;
        
        for(int iterator = 0; iterator < arr.size(); iterator++){
            if(arr.get(iterator) > 0) {
                numberPositiveValue++;
            }else{
                if(arr.get(iterator) < 0) {
                    numberNegativeValue++;
                }else{
                    numberZeroValue++;
                } 
            }            
        }
        positiveValue = (double) numberPositiveValue / arr.size();
        negativeValue = (double)numberNegativeValue / arr.size();
        zeroValue = (double) numberZeroValue / arr.size();
        
        
        System.out.printf("%.6f %n",positiveValue);
        System.out.printf("%.6f %n",negativeValue);
        System.out.printf("%.6f %n",zeroValue);
        
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
