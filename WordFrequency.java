import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take file path input
        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            // Count word frequency using Streams
            Map<String, Long> wordCount = lines
                    .flatMap(line -> Arrays.stream(line.toLowerCase().split("\\W+"))) // split by non-words
                    .filter(word -> !word.isBlank()) // remove empty words
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

            // Print result
            System.out.println("\nWord Frequency:");
            wordCount.forEach((word, count) -> 
                System.out.println(word + " -> " + count));

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
