import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class CSVParser {
    // Record to represent each row
    record Employee(int id, String name, double salary) {}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();

        List<Employee> employees = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            // Skip header (first line)
            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double salary = Double.parseDouble(parts[2].trim());

                    employees.add(new Employee(id, name, salary));
                }
            }

            System.out.println("\n Parsed Records:");
            employees.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
