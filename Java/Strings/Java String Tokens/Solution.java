/*
 java 8
*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String trimedStr = s.trim();
        
        if(trimedStr.length() > 0){
        
          String[] notokn = trimedStr.split("\\s*[^a-zA-Z]+\\s*");

          System.out.println(notokn.length);

          for (String token : notokn) {
              System.out.println(token);
          }
        }else{
            System.out.println(0);
        }
        
        
        scan.close();
    }
}

