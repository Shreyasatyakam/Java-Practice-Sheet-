import java.util.*;
import java.util.stream.Collectors;

class Employees {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupEmployees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee name: ");
            String name = sc.nextLine();
            System.out.print("Enter department: ");
            String dept = sc.nextLine();
            employees.add(new Employee(name, dept));
        }

        // Group employees by department using Streams
        Map<String, List<Employee>> grouped =
            employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nEmployees grouped by department:");
        grouped.forEach((dept, emps) -> 
            System.out.println(dept + " -> " + emps));

        sc.close();
    }
}
