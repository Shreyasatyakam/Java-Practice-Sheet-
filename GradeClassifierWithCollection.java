import java.util.*;

public class GradeClassifierWithCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Use Map to store grade messages
        Map<String, String> gradeMessages = Map.of(
            "A", "Excellent ",
            "B", "Very Good ",
            "C", "Good, but can improve",
            "D", "Needs improvement ",
            "E", "Poor, must work hard",
            "F", "Fail "
        );

        System.out.print("Enter your grade (A–F): ");
        String grade = sc.next().toUpperCase();

        // Lookup grade in the map
        String message = gradeMessages.getOrDefault(grade, "Invalid grade entered");

        System.out.println("Your Grade: " + grade + " → " + message);

        sc.close();
    }
}
