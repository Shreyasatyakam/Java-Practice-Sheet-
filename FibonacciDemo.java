import java.util.*;

public class FibonacciDemo {

    //  Naive Recursion
    static int fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Memoization (Top-Down DP)
    static int fibMemo(int n, Map<Integer, Integer> memo) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);

        int value = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        memo.put(n, value);
        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (Fibonacci term): ");
        int n = sc.nextInt();

        // Recursive approach
        long start1 = System.nanoTime();
        int result1 = fibRecursive(n);
        long end1 = System.nanoTime();

        // Memoized approach
        long start2 = System.nanoTime();
        int result2 = fibMemo(n, new HashMap<>());
        long end2 = System.nanoTime();

        System.out.println("\nUsing Recursion: fib(" + n + ") = " + result1 + " (time: " + (end1 - start1) + " ns)");
        System.out.println("Using Memoization: fib(" + n + ") = " + result2 + " (time: " + (end2 - start2) + " ns)");

        sc.close();
    }
}
