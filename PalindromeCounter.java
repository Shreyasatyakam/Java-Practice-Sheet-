import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class PalindromeCounter {

    // Check if a word is palindrome
    private static boolean isPalindrome(String word) {
        String cleaned = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right))
                return false;
            left++;
            right--;
        }
        return cleaned.length() > 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter path to the text file: ");
        String filePath = sc.nextLine();

        Path path = Path.of(filePath);

        if (!Files.exists(path)) {
            System.out.println("❌ File does not exist.");
            sc.close();
            return;
        }

        int palindromeCount = 0;

        try {
            for (String line : Files.readAllLines(path)) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (isPalindrome(word)) {
                        palindromeCount++;
                    }
                }
            }

            System.out.println("Total palindromes in the file: " + palindromeCount);

        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
