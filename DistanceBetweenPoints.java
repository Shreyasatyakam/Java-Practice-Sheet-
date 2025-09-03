import java.util.Scanner;

record Point(double x, double y) { }

public class DistanceBetweenPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take first point input
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();

        // Take second point input
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        // Create immutable points
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        // Calculate distance
        double distance = Math.sqrt(Math.pow(p2.x() - p1.x(), 2) + Math.pow(p2.y() - p1.y(), 2));

        System.out.printf("Distance between %s and %s = %.2f%n", p1, p2, distance);

        sc.close();
    }
}
