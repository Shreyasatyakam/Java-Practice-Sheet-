import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashtagExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a text containing hashtags:");
        String text = sc.nextLine();

        // Regex pattern for hashtags
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(text);

        System.out.println("\nFound hashtags:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("No hashtags found.");
        }

        sc.close();
    }
}
