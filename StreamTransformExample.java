import java.util.*;
import java.util.stream.Collectors;

public class StreamTransformExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers separated by space:");
        String[] input = sc.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String s : input) numbers.add(Integer.parseInt(s));

        // Example 1: filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Example 2: square all numbers
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared numbers: " + squaredNumbers);

        // Example 3: filter odd numbers and double them
        List<Integer> doubledOdds = numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Doubled odd numbers: " + doubledOdds);

        sc.close();
    }
}
