/*
 java 15
*/
import java.util.Scanner;
import java.util.*;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        
        HashMap<Character, Integer> aFrequency = new HashMap<Character, Integer>();
        HashMap<Character, Integer> bFrequency = new HashMap<Character, Integer>();
        Integer frequency;
        String aCap = a.toUpperCase();
        String bCap = b.toUpperCase();
        
        if(a.length() != b.length()){
            return false;
        }
        
        for (int i = 0; i< a.length(); i++ ) {
            Character letter = aCap.charAt(i);
            if(aFrequency.containsKey(letter)) 
            { 
                frequency = aFrequency.get(letter); 
                frequency++; 
                aFrequency.put(letter, frequency); 
            } 
            else
            { 
                aFrequency.put(letter, 1); 
            } 
            
        }
        for (int i = 0; i< b.length(); i++ ) {
            Character letter = bCap.charAt(i);
            if(bFrequency.containsKey(letter)) 
            { 
                frequency = bFrequency.get(letter); 
                frequency++; 
                bFrequency.put(letter, frequency); 
            } 
            else
            { 
                bFrequency.put(letter, 1); 
            } 
            
        }
        
        for (int i = 0; i< a.length(); i++ ) {
            Character letter = aCap.charAt(i);
            if(aFrequency.get(letter) != bFrequency.get(letter)) 
            { 
                return false;
            } 
            
        }
        return true;
        
        
        
        
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
