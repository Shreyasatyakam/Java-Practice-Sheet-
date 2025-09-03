import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String line = sc.nextLine();

        String reversed = reverseWords(line);
        System.out.println("Reversed words: " + reversed);

        sc.close();
    }

    // Reverse words without using split() or other library tokenizers
    static String reverseWords(String s) {
        if (s == null || s.isBlank()) return "";

        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // skip spaces
            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break;

            // find start of the word
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            int start = i + 1;

            // append the word
            if (result.length() > 0) result.append(' ');
            for (int k = start; k <= end; k++) {
                result.append(s.charAt(k));
            }
        }

        return result.toString();
    }
}
