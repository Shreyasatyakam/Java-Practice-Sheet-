import java.time.*;
import java.util.*;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for DOB
        System.out.print("Enter your date of birth (yyyy-mm-dd): ");
        String dobInput = sc.nextLine();

        LocalDate dob = LocalDate.parse(dobInput);  // parse input
        LocalDate today = LocalDate.now();          // current date

        // Calculate age
        Period age = Period.between(dob, today);

        System.out.println("Your age is: " 
                           + age.getYears() + " years, " 
                           + age.getMonths() + " months, and " 
                           + age.getDays() + " days.");

        sc.close();
    }
}
