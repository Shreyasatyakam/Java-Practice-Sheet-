import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordValidator {
    // One regex to enforce all rules
    private static final Pattern STRONG_PWD =
            Pattern.compile("^" +
                    "(?=.*[a-z])" +        // at least one lowercase
                    "(?=.*[A-Z])" +        // at least one uppercase
                    "(?=.*\\d)" +          // at least one digit
                    "(?=.*[^A-Za-z0-9])" + // at least one special char
                    "(?=\\S+$)" +          // no whitespace
                    ".{8,}" +              // min length 8
                    "$");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password to validate: ");
        String pwd = sc.nextLine();

        if (STRONG_PWD.matcher(pwd).matches()) {
            System.out.println("Strong password");
        } else {
            System.out.println("Weak password");
            // Optional: quick hints (lightweight checks)
            if (pwd.length() < 8) System.out.println("- Must be at least 8 characters");
            if (!pwd.matches(".*[A-Z].*")) System.out.println("- Add an uppercase letter");
            if (!pwd.matches(".*[a-z].*")) System.out.println("- Add a lowercase letter");
            if (!pwd.matches(".*\\d.*")) System.out.println("- Add a digit");
            if (!pwd.matches(".*[^A-Za-z0-9].*")) System.out.println("- Add a special character");
            if (pwd.matches(".*\\s.*")) System.out.println("- Remove spaces");
        }

        sc.close();
    }
}
