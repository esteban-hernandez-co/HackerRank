/*
java 15
*/
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            
            // Regex for digit from 0 to 255.
            String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    
            // Regex for a digit from 0 to 255 and
            // followed by a dot, repeat 4 times.
            // this is the regex to validate an IP address.
            String regex
                = zeroTo255 + "\\."                + zeroTo255 + "\\."
                + zeroTo255 + "\\."                + zeroTo255;
    
            // Compile the ReGex
            Pattern p = Pattern.compile(regex);
    
            // If the IP address is empty
            // return false
            if (IP == null) {
                System.out.println("false");
            }
    
            // Pattern class contains matcher() method
            // to find matching between given IP address
            // and regular expression.
            Matcher m = p.matcher(IP);
    
            // Return if the IP address
            // matched the ReGex
            System.out.println(m.matches());
        }
        
    }
}
