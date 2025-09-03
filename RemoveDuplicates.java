import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numbers separated by space: ");
        String input = sc.nextLine();

        // Convert input to list of integers
        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        System.out.println("Original List: " + numbers);

        // Remove duplicates using stream distinct()
        List<Integer> uniqueNumbers = numbers.stream()
                                             .distinct()
                                             .collect(Collectors.toList());

        System.out.println("List after removing duplicates: " + uniqueNumbers);

        sc.close();
    }
}
