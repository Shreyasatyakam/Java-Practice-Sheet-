import java.util.Scanner;

public class PascalsTriangle {

    // Compute factorial
    private static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    }

    // Compute nCr
    private static long nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.println("Pascal's Triangle:");
        for (int i = 0; i < rows; i++) {
            // Print leading spaces
            for (int j = 0; j < rows - i - 1; j++)
                System.out.print("  ");

            // Print numbers
            for (int j = 0; j <= i; j++)
                System.out.print(nCr(i, j) + "   ");

            System.out.println();
        }

        sc.close();
    }
}
