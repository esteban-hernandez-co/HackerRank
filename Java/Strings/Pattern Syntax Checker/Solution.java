/*
 java 8
*/
import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
	public static void main(String[] args){
        try{
            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());
            while(testCases>0){
                String pattern = in.nextLine();
                //Write your code
                try{
                    Pattern patt = Pattern.compile(pattern);
                    System.out.println("Valid");
                }catch(Exception e){
                    System.out.println("Invalid");
                }
                testCases--;
            }
            in.close();   
        }catch(Exception e){
            System.out.println(e);
        }
        
        
		
	}
}



