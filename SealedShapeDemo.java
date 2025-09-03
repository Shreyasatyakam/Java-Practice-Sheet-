import java.util.Scanner;

// Sealed superclass
sealed abstract class Shape permits Circle, Rectangle, Triangle {
    public abstract double area();
}

// Subclass 1: Circle
final class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Subclass 2: Rectangle
final class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// Subclass 3: Triangle
final class Triangle extends Shape {
    private double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// Main class with user input
public class SealedShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a shape: 1) Circle  2) Rectangle  3) Triangle");
        int choice = sc.nextInt();

        Shape shape = null;

        switch (choice) {
            case 1 -> {
                System.out.print("Enter radius: ");
                double r = sc.nextDouble();
                shape = new Circle(r);
            }
            case 2 -> {
                System.out.print("Enter width: ");
                double w = sc.nextDouble();
                System.out.print("Enter height: ");
                double h = sc.nextDouble();
                shape = new Rectangle(w, h);
            }
            case 3 -> {
                System.out.print("Enter base: ");
                double b = sc.nextDouble();
                System.out.print("Enter height: ");
                double ht = sc.nextDouble();
                shape = new Triangle(b, ht);
            }
            default -> System.out.println("Invalid choice!");
        }

        if (shape != null) {
            System.out.println("Area = " + shape.area());
        }

        sc.close();
    }
}
