import java.util.*;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Sliding window with HashMap
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, maxLen = 0, startIndex = 0;

        for (int end = 0; end < input.length(); end++) {
            char ch = input.charAt(end);

            // If character repeats, move start ahead
            if (map.containsKey(ch) && map.get(ch) >= start) {
                start = map.get(ch) + 1;
            }

            map.put(ch, end);

            // Update max length and starting index
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                startIndex = start;
            }
        }

        String longest = input.substring(startIndex, startIndex + maxLen);
        System.out.println("Longest substring without repeating characters: " + longest);
        System.out.println("Length: " + maxLen);

        sc.close();
    }
}
