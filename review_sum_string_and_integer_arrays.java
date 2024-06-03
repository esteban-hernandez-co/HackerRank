import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MultiSum{
    public static Integer sum(Integer[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
    public static String sum(String[] arr){
        return arr.toString();        
    }
}
private static Integer tryParseInt(String input) {
        try {
            // Attempt to parse the string to an integer
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Parsing failed
            return null;
        }
    }

public class Solution {
    public static void main(String args[] ) throws Exception {
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");     
        boolean is_string = false;
        
        
        for(int i = 0; i< firstMultipleInput.length; i++){
            Integer result = tryParseInt(firstMultipleInput[i]);
            
            if (result == null) {
                System.out.println(sum(firstMultipleInput));
                is_string = true;
                break;
            }
        }
        if(!is_string){
            List<Integer> ints = Stream.of(firstMultipleInput)
            .map(Integer::parseInt)
            .collect(toList());
            
        }
        
        
        bufferedReader.close();
    }
}