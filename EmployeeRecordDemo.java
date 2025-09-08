
public record Employee(int id, String name, double salary) {
    
    public Employee {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative!");
        }
    }
}

class EmployeeRecordDemo {
    public static void main(String[] args) {
        
        Employee emp1 = new Employee(101, "Alice", 55000);

      
        System.out.println(emp1);

       
        System.out.println("ID: " + emp1.id());
        System.out.println("Name: " + emp1.name());
        System.out.println("Salary: " + emp1.salary());

    }
}
