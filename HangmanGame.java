import java.util.*;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Predefined word list (you can expand it)
        String[] words = {"java", "hangman", "programming", "computer", "developer"};
        Random random = new Random();

        // Pick random word
        String word = words[random.nextInt(words.length)];
        char[] guessed = new char[word.length()];
        Arrays.fill(guessed, '_');

        int attempts = 6; // number of wrong guesses allowed
        Set<Character> usedLetters = new HashSet<>();

        System.out.println("🎯 Welcome to Hangman!");
        System.out.println("Guess the word: " + String.valueOf(guessed));

        while (attempts > 0 && new String(guessed).contains("_")) {
            System.out.print("\nEnter a letter: ");
            char guess = sc.next().toLowerCase().charAt(0);

            if (usedLetters.contains(guess)) {
                System.out.println("⚠️ You already tried '" + guess + "'. Try another letter.");
                continue;
            }

            usedLetters.add(guess);

            boolean correct = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessed[i] = guess;
                    correct = true;
                }
            }

            if (correct) {
                System.out.println("✅ Good guess!");
            } else {
                attempts--;
                System.out.println("❌ Wrong guess! Attempts left: " + attempts);
            }

            System.out.println("Word: " + String.valueOf(guessed));
            System.out.println("Used letters: " + usedLetters);
        }

        if (new String(guessed).equals(word)) {
            System.out.println("\n🎉 Congratulations! You guessed the word: " + word);
        } else {
            System.out.println("\n💀 Game Over! The word was: " + word);
        }

        sc.close();
    }
}
