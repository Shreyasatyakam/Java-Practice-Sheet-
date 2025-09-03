import java.util.Scanner;

public class GradeClassifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your marks (0–100): ");
        int marks = sc.nextInt();

        String grade = switch (marks / 10) {
            case 10, 9 -> "A (Excellent 🎉)";
            case 8 -> "B (Very Good 🙂)";
            case 7 -> "C (Good, but can improve)";
            case 6 -> "D (Needs improvement 😕)";
            case 5 -> "E (Poor, must work hard)";
            default -> "F (Fail ❌)";
        };

        System.out.println("Your Grade: " + grade);

        sc.close();
    }
}
