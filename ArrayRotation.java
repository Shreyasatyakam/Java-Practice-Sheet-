import java.util.*;

public class ArrayRotation {
    // Function to rotate array to the right k times
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle if k > n

        reverse(arr, 0, n - 1);       // Reverse whole array
        reverse(arr, 0, k - 1);       // Reverse first k elements
        reverse(arr, k, n - 1);       // Reverse remaining elements
    }

    // Helper function to reverse part of array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take array input
        System.out.print("Enter array elements (space separated): ");
        String[] parts = sc.nextLine().split(" ");
        int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

        // Take k input
        System.out.print("Enter number of rotations (k): ");
        int k = sc.nextInt();

        // Rotate array
        rotate(arr, k);

        // Print result
        System.out.println("Rotated Array: " + Arrays.toString(arr));

        sc.close();
    }
}
