
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem {

    public static List<Integer> findNumbersWithCount(int[] listOfNumbers, int countOfOccurrenceThreshold) {
        // Check if the input array is null or empty
        if (listOfNumbers == null || listOfNumbers.length == 0) {
            return new ArrayList<>();
        }

        // Convert the array to a stream
        return Arrays.stream(listOfNumbers)
                // Box each integer to Integer object
                .boxed()
                // Collect the numbers into a map where the key is the number and the value is its count
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                // Filter the entries to keep only those with count >= countOfOccurrenceThreshold
                .entrySet().stream()
                .filter(entry -> entry.getValue() >= countOfOccurrenceThreshold)
                // Map back to Integer objects
                .map(Map.Entry::getKey)
                // Collect the results into a list
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> x = findNumbersWithCount(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);
    }
}