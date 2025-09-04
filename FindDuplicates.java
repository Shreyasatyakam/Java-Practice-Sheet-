import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take array input
        System.out.print("Enter array elements (space separated): ");
        String[] parts = sc.nextLine().split(" ");
        int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

        // Find duplicates using Set
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        // Print results
        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicate elements: " + duplicates);
        }

        sc.close();
    }
}
