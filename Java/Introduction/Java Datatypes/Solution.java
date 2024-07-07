import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        
        
                
        for(int q=0; q<queries; q++){
            try{
                long a = scanner.nextLong();
                
                System.out.println(String.format("%s can be fitted in:",a));    
                try{
                    byte b = (byte) a;
                    if(b == a)
                        System.out.println(String.format("* byte"));    
                    
                }catch(Exception e){}
                
                try{
                    short s = (short) a;
                    if(s == a)
                        System.out.println(String.format("* short"));    
                    
                }catch(Exception e){}
                
                try{
                    int i = (int) a;
                    if(i == a)
                        System.out.println(String.format("* int"));    
                    
                }catch(Exception e){}
                
                System.out.println(String.format("* long"));    
                
                
            }
            catch(Exception e)
            {
                System.out.println(scanner.next()+" can't be fitted anywhere.");
            }
        }
        

        scanner.close();   
    }
}