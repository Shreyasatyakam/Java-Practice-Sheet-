import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base Employee class
class Employee80 {
    private String name;
    private double basicSalary;

    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // Calculate total salary (can be overridden)
    public double calculateSalary() {
        double hra = basicSalary * 0.2;   // House Rent Allowance
        double da = basicSalary * 0.1;    // Dearness Allowance
        return basicSalary + hra + da;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Basic Salary: " + basicSalary +
               ", Total Salary: " + calculateSalary();
    }
}

// Manager subclass (example of inheritance)
class Manager extends Employee {
    private double bonus;

    public Manager(String name, double basicSalary, double bonus) {
        super(name, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus;
    }

    @Override
    public String toString() {
        return "Manager - " + super.toString() + ", Bonus: " + bonus;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for employee " + (i + 1));
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter basic salary: ");
            double basicSalary = sc.nextDouble();
            sc.nextLine(); // consume newline

            System.out.print("Is this employee a manager? (yes/no): ");
            String isManager = sc.nextLine().trim();

            if (isManager.equalsIgnoreCase("yes")) {
                System.out.print("Enter bonus: ");
                double bonus = sc.nextDouble();
                sc.nextLine(); // consume newline
                employees.add(new Manager(name, basicSalary, bonus));
            } else {
                employees.add(new Employee(name, basicSalary));
            }
        }

        System.out.println("\n--- Payroll Details ---");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        sc.close();
    }
}
