import java.util.*;

public class MaxKItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter item values:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // Min-heap to store k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int val : arr) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int maxSum = 0;
        while (!minHeap.isEmpty()) {
            maxSum += minHeap.poll();
        }

        System.out.println("Maximum total value: " + maxSum);
    }
}
