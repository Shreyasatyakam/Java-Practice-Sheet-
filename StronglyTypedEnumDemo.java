import java.util.Scanner;

enum Day {
    MONDAY("Weekday", false),
    TUESDAY("Weekday", false),
    WEDNESDAY("Weekday", false),
    THURSDAY("Weekday", false),
    FRIDAY("Weekday", false),
    SATURDAY("Weekend", false),
    SUNDAY("Weekend", true);

    private final String type;
    private final boolean holiday;

    // Constructor
    Day(String type, boolean holiday) {
        this.type = type;
        this.holiday = holiday;
    }

    public String getType() {
        return type;
    }

    public boolean isHoliday() {
        return holiday;
    }
}

public class StronglyTypedEnumDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for a day
        System.out.print("Enter a day (e.g., MONDAY, TUESDAY): ");
        String input = sc.nextLine().trim().toUpperCase();

        try {
            Day day = Day.valueOf(input);
            System.out.println("Day: " + day);
            System.out.println("Type: " + day.getType());
            System.out.println("Holiday: " + day.isHoliday());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Invalid day entered!");
        }

        sc.close();
    }
}
