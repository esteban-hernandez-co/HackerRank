import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int line = 1;
        while(scanner.hasNext()){
            System.out.println(String.format("%s %s",line,scanner.nextLine()));
            line++;
        }
    }
}