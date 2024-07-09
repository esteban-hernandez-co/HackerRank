import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("================================");
        for(int i =0; i<3; i++){
            String myString = scanner.next();
            int myInt = scanner.nextInt();
            System.out.print(String.format("%-15s", myString));
            System.out.println(String.format("%03d", myInt));
            
        }
        
        
        scanner.close();
        System.out.println("================================");

        
    }
}