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
     * Complete the 'insertionSort' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
     
     private static long swaps;
     
     private static List<Integer> getRightHalf(List<Integer> array) {
        return array.subList(array.size() / 2, array.size());
    }

    private static List<Integer> getLeftHalf(List<Integer> array) {
        return array.subList(0, array.size() / 2);
    }

    private static boolean leftHalfHasRemainingElements(List<Integer> left, int leftI) {
        return leftI < left.size();
    }

    private static void addRIghtElementToResult(List<Integer> right, int rightI, List<Integer> result) {
        result.add(right.get(rightI));
    }

    private static boolean bothHalfsHaveElements(List<Integer> left, List<Integer> right, int leftI, int rightI) {
        return leftI < left.size() && rightI < right.size();
    }

    private static void addLeftElementToResult(List<Integer> left, int leftI, List<Integer> result) {
        addRIghtElementToResult(left, leftI, result);
    }

    private static boolean nextElementsAreOrdered(List<Integer> left, List<Integer> right, int leftI, int rightI) {
        return left.get(leftI) <= right.get(rightI);
    }
    private static List<Integer> sort(List<Integer> array) {
        if (array.size() == 1) {
            return array;
        } else {
            List<Integer> left = getLeftHalf(array);
            List<Integer> right = getRightHalf(array);
            return merge(sort(left), sort(right));
        }
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftI = 0;
        int rightI = 0;
        List<Integer> result = new ArrayList<>();
        // Merge Both Arrays
        while (bothHalfsHaveElements(left, right, leftI, rightI)) {
            if (nextElementsAreOrdered(left, right, leftI, rightI)) {
                addLeftElementToResult(left, leftI, result);
                leftI++;
            } else {

                                // Here we insert from the right half and have to sum swaps
                addRIghtElementToResult(right, rightI, result);
                rightI++;
                swaps += left.size() - leftI;
            }
        }
        // Fill with the remaining
        if (leftHalfHasRemainingElements(left, leftI)) {
            result.addAll(left.subList(leftI, left.size()));
        } else {
            result.addAll(right.subList(rightI, right.size()));
        }
        return result;
    }
    

    public static long insertionSort(List<Integer> arr) {
    // Write your code here
    
        swaps = 0;
        sort(arr);
        return swaps;       

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                long result = Result.insertionSort(arr);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
