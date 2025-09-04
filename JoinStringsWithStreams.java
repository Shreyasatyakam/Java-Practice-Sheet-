import java.util.*;
import java.util.stream.Collectors;

public class JoinStringsWithStreams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings.add(sc.nextLine());
        }

        System.out.print("Enter delimiter: ");
        String delimiter = sc.nextLine();

        // Use Streams to join with delimiter
        String result = strings.stream()
                .collect(Collectors.joining(delimiter));

        System.out.println("Joined string: " + result);

        sc.close();
    }
}
