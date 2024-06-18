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
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        // Write your code here
        String upperCasedStr = s.toUpperCase();
        String[] alphabet = new String[]{"A","B","C","D","E",
                                         "F","G","H","I","J",
                                         "K","L","M","N","O",
                                         "P","Q","R","S","T",
                                         "U","V","W","X","Y","Z"};
        Set<String> pangramTracker = new HashSet<>(Arrays.asList(alphabet));
        
        for (char letter : upperCasedStr.toCharArray()) {
            if(pangramTracker.contains(Character.toString(letter))){
                pangramTracker.remove(Character.toString(letter));
            }
            
            if(pangramTracker.isEmpty()){
                return "pangram";
            }
        }
        
        return "not pangram";
        
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
