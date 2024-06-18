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
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
        // Write your code here
        //"SOS"
        int messagesSent = s.length() / 3;
        int lettersChanged = 0;
        for(int messageNo = 0; messageNo< messagesSent; messageNo++){
            //0 -> 0,1,2
            //1 -> 3,4,5
            
            if( !"S".equals(String.valueOf(s.charAt( (messageNo * 3) ))) ) lettersChanged++;
            if( !"O".equals(String.valueOf(s.charAt( (messageNo * 3)+1 ))) ) lettersChanged++;
            if( !"S".equals(String.valueOf(s.charAt( (messageNo * 3)+2 ))) ) lettersChanged++;
            
        }
        return lettersChanged;
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
