import java.util.*;
import java.util.stream.Collectors;

public class ParallelStreamsDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input dataset
        System.out.print("Enter numbers separated by spaces: ");
        String input = sc.nextLine();

        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        // Process dataset using parallel stream
        System.out.println("\nOriginal dataset: " + numbers);

        // Example 1: Filter even numbers
        List<Integer> evens = numbers.parallelStream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Even numbers (parallel): " + evens);

        // Example 2: Square each number
        List<Integer> squares = numbers.parallelStream()
                                       .map(n -> n * n)
                                       .collect(Collectors.toList());
        System.out.println("Squares (parallel): " + squares);

        // Example 3: Sum of numbers
        int sum = numbers.parallelStream()
                         .mapToInt(Integer::intValue)
                         .sum();
        System.out.println("Sum (parallel): " + sum);

        sc.close();
    }
}
