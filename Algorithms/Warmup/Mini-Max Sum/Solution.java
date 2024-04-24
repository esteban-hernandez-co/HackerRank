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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        long min = 0l;
        long max = 0l;
        for(int iterator = 0; iterator < arr.size(); iterator++){
            long sum = 0l;
            for(int iter_within = 0; iter_within < arr.size(); iter_within++){
                if(iterator != iter_within){
                    sum += arr.get(iter_within);
                }
                if(iterator == 0 ){
                    //assign variable min for the first time
                    min = sum;
                }
                
            }
            if(sum >= max) max = sum;       
            if(sum <= min) min = sum;
        }
        System.out.format("%s %s",min, max);
                
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
