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

    public static int hourglass(int hourGlassVerti,int hourGlassVertj, List<List<Integer>> arr){
        
        int sum = 0;
        
        for(int i = hourGlassVerti ; i < hourGlassVerti + 3; i++){
            for(int j = hourGlassVertj ; j < hourGlassVertj + 3; j++){
                if(i == hourGlassVerti || i == hourGlassVerti + 2)
                    sum += arr.get(i).get(j);
                else
                    if(i == hourGlassVerti + 1 && j == hourGlassVertj + 1)
                        sum += arr.get(i).get(j);
                    
            }    
        }
        return sum;
    }
    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
        int min = 0;
        int max = 0;
        int sum = 0;
        
        for(int i = 0 ; i < 4; i++){
            for(int j = 0 ; j < 4; j++){
                sum = hourglass(i, j, arr);
                if(i == 0 & j == 0) {min = sum; max = sum;}
                if(sum > max) max = sum;
                if(sum < min) min = sum;
            }    
        }
        return max;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
