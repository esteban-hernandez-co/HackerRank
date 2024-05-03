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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int highest_score = 0;
        int lowest_score = Integer.MAX_VALUE;
        int min = 0;
        int max = 0;
        
        
        for(int game = 0; game < scores.size(); game++){
            //compare the highest score
            if(scores.get(game) > highest_score){
                highest_score = scores.get(game);
                if(game > 0) max++;
            }
            //compare the lowest score
            if(scores.get(game) < lowest_score){
                lowest_score = scores.get(game);
                if(game > 0) min++;
            }
            /*
                System.out.print(String.format("Game: %s ", game)); 
                System.out.print(String.format("score: %s ", scores.get(game))); 
                System.out.print(String.format("Max: %s ", max)); 
                System.out.println(String.format("Min: %s ", min)); 
            */
        
            
        }
        List<Integer> max_min = new ArrayList<>(Arrays.asList(max, min));
        
        return max_min;

    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
