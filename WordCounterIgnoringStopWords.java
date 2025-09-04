import java.util.*;
import java.util.stream.Collectors;

public class WordCounterIgnoringStopWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example stop words list
        Set<String> stopWords = Set.of("a", "an", "the", "is", "are", "in", "on", "at", "of", "for", "and", "to");

        // Take input text
        System.out.println("Enter a paragraph of text:");
        String text = sc.nextLine().toLowerCase();

        // Split into words, filter stop words, count frequency
        Map<String, Long> wordCount = Arrays.stream(text.split("\\W+"))
                .filter(word -> !word.isBlank() && !stopWords.contains(word))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // Print results
        if (wordCount.isEmpty()) {
            System.out.println("No valid words found after removing stop words.");
        } else {
            System.out.println("\nWord Frequency (ignoring stop words):");
            wordCount.forEach((word, count) -> System.out.println(word + " -> " + count));
        }

        sc.close();
    }
}

