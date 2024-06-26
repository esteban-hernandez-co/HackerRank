/*
    Java 15
    
    I'll make it simple and read the input one by one
    
    Note: If you use the nextLine() method immediately following the nextInt() method, recall that nextInt()    
    reads integer tokens; because of this, the last newline character for that line of integer input is   
    still queued in the input buffer and the next nextLine() will be reading the remainder of the integer line  (which is empty).
    
*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        
        int myInt = scanner.nextInt();
        double myDouble = scanner.nextDouble();
        scanner.nextLine(); //gets rid of \n after reading our Double
        String myString = scanner.nextLine();
        
        scanner.close();

        System.out.println(String.format("String: %s", myString));
        System.out.println(String.format("Double: %s", myDouble));
        System.out.println(String.format("Int: %s", myInt));
    }
}
