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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
        int extraChars = 0;
        boolean digitOccurred = false;
        boolean lowerCaseOccurred = false;
        boolean upperCaseOccurred = false;
        boolean specialCharOccurred = false;
        int desiredLength = 0;
        
        for(char letter : password.toCharArray()){
           if (letter >= 48 && letter <= 57)
                digitOccurred = true;

            if (letter >= 97 && letter <= 122)
                lowerCaseOccurred = true;

            if (letter >= 65 && letter <= 90)
                upperCaseOccurred = true;


            if (letter == 33
               || letter == 64
               || letter == 94
               || letter == 45
               ) //!@^-
                specialCharOccurred = true;

            if (letter >= 35 && letter <= 38) //#$%&
                specialCharOccurred = true;


            if (letter >= 40 && letter <= 43) //()*+
                specialCharOccurred = true;

            desiredLength++; 
            if (digitOccurred && lowerCaseOccurred && upperCaseOccurred && specialCharOccurred && desiredLength >= 6)
                break;
        }
        if (!digitOccurred)
            extraChars++;

        if (!lowerCaseOccurred)
            extraChars++;

        if (!upperCaseOccurred)
            extraChars++;

        if (!specialCharOccurred)
            extraChars++;

        if (desiredLength + extraChars < 6)
            extraChars += 6 - extraChars - desiredLength;

        return extraChars;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
