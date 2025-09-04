import java.util.*;
import java.util.stream.Collectors;

public class PartitionOddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter numbers separated by space: ");
        String input = sc.nextLine();

        // Convert input string to list of integers
        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                                      .map(Integer::parseInt)
                                      .toList();

        // Partition numbers into odd/even using Streams
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        // Print results
        System.out.println("Even Numbers: " + partitioned.get(true));
        System.out.println("Odd Numbers: " + partitioned.get(false));
    }
}
