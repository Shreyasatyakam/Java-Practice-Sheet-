import java.util.*;

public class HeapSort {
    // Main heap sort function
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (largest) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify a subtree rooted at index i
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;         // root
        int left = 2 * i + 1;    // left child
        int right = 2 * i + 2;   // right child

        // If left child is larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If root is not largest, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter numbers separated by space: ");
        String[] parts = sc.nextLine().split("\\s+");
        int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

        // Sort array
        heapSort(arr);

        // Print sorted array
        System.out.println("Sorted array: " + Arrays.toString(arr));

        sc.close();
    }
}
