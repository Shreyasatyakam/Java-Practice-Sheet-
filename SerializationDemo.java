import java.io.*;
import java.util.Scanner;

// Serializable class
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // toString method for printing
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take employee details from user
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, salary);

        String fileName = "employee.ser";

        // Serialize object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(emp);
            System.out.println("\nEmployee object serialized to " + fileName);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialize object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Employee deserializedEmp = (Employee) ois.readObject();
            System.out.println("Deserialized Employee: " + deserializedEmp);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }

        sc.close();
    }
}
