// Immutable Employee using record
public record Employee(int id, String name, double salary) {
    // Compact constructor to add validation if needed
    public Employee {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative!");
        }
    }
}

class EmployeeRecordDemo {
    public static void main(String[] args) {
        // Create Employee object
        Employee emp1 = new Employee(101, "Alice", 55000);

        // Print details
        System.out.println(emp1);

        // Access fields (getters are auto-generated with same name as fields)
        System.out.println("ID: " + emp1.id());
        System.out.println("Name: " + emp1.name());
        System.out.println("Salary: " + emp1.salary());

        // Uncommenting below line would cause compile error (immutable)
        // emp1.name = "Bob";
    }
}
