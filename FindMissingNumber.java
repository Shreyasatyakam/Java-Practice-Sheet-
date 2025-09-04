import java.util.*;

public class FindMissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take array input
        System.out.print("Enter array elements (space separated, with one missing in sequence): ");
        String[] parts = sc.nextLine().split(" ");
        int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

        int n = arr.length + 1; // since one number is missing
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(arr).sum();

        int missing = expectedSum - actualSum;

        System.out.println("Missing number is: " + missing);

        sc.close();
    }
}
