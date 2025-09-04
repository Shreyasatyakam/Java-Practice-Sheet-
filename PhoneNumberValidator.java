import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Regex: allows optional +91 or 0, followed by 10 digits starting 6-9
        String regex = "^(\\+91|0)?[6-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        if (pattern.matcher(phone).matches()) {
            System.out.println("✅ Valid phone number");
        } else {
            System.out.println("❌ Invalid phone number");
        }

        sc.close();
    }
}
