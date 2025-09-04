import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URLShortener {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int SHORT_CODE_LENGTH = 6;

    private final Map<String, String> longToShort = new HashMap<>();
    private final Map<String, String> shortToLong = new HashMap<>();
    private int counter = 1;

    // Encode an integer to base62
    private String encode(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(BASE62.charAt(num % 62));
            num /= 62;
        }
        while (sb.length() < SHORT_CODE_LENGTH) {
            sb.append('0'); // pad with 0
        }
        return sb.reverse().toString();
    }

    // Shorten a long URL
    public String shortenURL(String longURL) {
        if (longToShort.containsKey(longURL)) {
            return longToShort.get(longURL);
        }
        String shortCode = encode(counter++);
        longToShort.put(longURL, shortCode);
        shortToLong.put(shortCode, longURL);
        return shortCode;
    }

    // Retrieve original URL
    public String retrieveURL(String shortCode) {
        return shortToLong.getOrDefault(shortCode, "URL not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        URLShortener shortener = new URLShortener();

        while (true) {
            System.out.println("\n--- URL Shortener ---");
            System.out.println("1. Shorten URL");
            System.out.println("2. Retrieve URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter long URL: ");
                    String longURL = sc.nextLine().trim();
                    String shortCode = shortener.shortenURL(longURL);
                    System.out.println("Short URL code: " + shortCode);
                }
                case 2 -> {
                    System.out.print("Enter short URL code: ");
                    String code = sc.nextLine().trim();
                    System.out.println("Original URL: " + shortener.retrieveURL(code));
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
