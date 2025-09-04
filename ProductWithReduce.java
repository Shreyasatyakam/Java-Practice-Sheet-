import java.util.*;
import java.util.stream.*;

public class ProductWithReduce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input numbers
        System.out.print("Enter numbers separated by space: ");
        String[] parts = sc.nextLine().split("\\s+");

        List<Integer> numbers = Arrays.stream(parts)
                                      .map(Integer::parseInt)
                                      .toList();

        // Calculate product using reduce()
        int product = numbers.stream()
                             .reduce(1, (a, b) -> a * b);

        System.out.println("Product of numbers = " + product);

        sc.close();
    }
}
