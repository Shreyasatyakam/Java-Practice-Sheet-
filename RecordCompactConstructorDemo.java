import java.util.Scanner;

public class RecordCompactConstructorDemo {

    // Record with compact constructor for validation
    record Person(String name, int age) {
        Person {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            name = name.trim(); // normalize
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt();

            Person p = new Person(name, age);
            System.out.println("✅ Person created: " + p);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        sc.close();
    }
}
