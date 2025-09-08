import java.util.*;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
          
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numbers separated by space: ");
        String[] parts = sc.nextLine().split("\\s+");
        int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        
        bubbleSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        sc.close();
    }
}
