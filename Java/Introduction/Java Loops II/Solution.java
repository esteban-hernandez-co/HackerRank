import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        
        for(int q=0; q<queries; q++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            int sum = 0;
            sum = a+(1*b);
            System.out.print(sum);
            for(int i=1; i<n; i++){           
                sum += (int)Math.pow(2, i) * b;
                System.out.print(" "+sum);
            }    
            System.out.println("");
        }

        scanner.close();
        
        
    }
}