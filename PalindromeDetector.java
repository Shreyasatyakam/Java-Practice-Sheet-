import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class PalindromeDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take file path from user
        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        try {
    List<String> lines = Files.readAllLines(Paths.get(filePath));
    List<String> palindromes = new ArrayList<>();

    for (String line : lines) {
        String[] words = line.split("\\W+"); // split line into words
        for (String word : words) {
            word = word.toLowerCase();
            if (word.length() > 1 && isPalindrome(word) && !palindromes.contains(word)) {
                palindromes.add(word);
            }
        }
    }

    System.out.println("\nPalindromes found:");
    palindromes.forEach(System.out::println);

} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
}
        sc.close();
    }

    // Check if a word is palindrome
    private static boolean isPalindrome(String word) {
        return new StringBuilder(word).reverse().toString().equals(word);
    }
}
