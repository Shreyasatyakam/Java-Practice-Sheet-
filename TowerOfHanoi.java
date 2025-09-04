import java.util.Scanner;

public class TowerOfHanoi {

    // Recursive function to solve Tower of Hanoi
    public static void solve(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Step 1: Move n-1 disks from source to auxiliary
        solve(n - 1, source, destination, auxiliary);

        // Step 2: Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move n-1 disks from auxiliary to destination
        solve(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        System.out.println("\n--- Tower of Hanoi Solution ---");
        solve(n, 'A', 'B', 'C'); // A = source, B = auxiliary, C = destination

        sc.close();
    }
}
