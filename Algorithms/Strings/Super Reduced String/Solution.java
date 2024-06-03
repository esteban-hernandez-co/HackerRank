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
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    

    public static String superReducedString(String s) {
    // Write your code here
        StringBuilder lastOutput = new StringBuilder(s);
        
        while(true){
            StringBuilder currentOutput = new StringBuilder("");
            String str = lastOutput.toString();
            char past = str.charAt(0);
            int count = 0;
            
            for(int i=0; i<str.length(); i++){
                char current = str.charAt(i);
                //System.out.println(String.format("past:%s current:%s", past, current));
                if(past == current)
                    count += 1;
                else if (count == 1)
                {
                    currentOutput.append(past);
                    count = 1;
                }
                else
                    count = 1;

                if(count == 2)
                    count = 0;

                past = current;
            }
            if(count == 1)
                currentOutput.append(str.charAt(str.length()-1));
            
            
            if(currentOutput.toString().equals(""))
            {
                return "Empty String";
            }
            
            
            if(currentOutput.toString().equals(lastOutput.toString()))
                break;
            else
                lastOutput = new StringBuilder(currentOutput.toString());
        }
        return lastOutput.toString();

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
