import java.util.*;

public class PerfectSquareCheck {
    public static boolean isPerfectSquare(int num) {
        if (num < 1) return false;
        long left = 1, right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) return true;
            if (square < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        System.out.println("Is perfect square? " + isPerfectSquare(num));
    }
}
