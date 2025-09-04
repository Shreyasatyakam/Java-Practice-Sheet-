import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /, %): ");
        String op = sc.next();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        // Switch expression in Java 17
        double result = switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("Error: Division by zero!");
                    yield Double.NaN; // yield is used in switch expressions
                } else {
                    yield num1 / num2;
                }
            }
            case "%" -> num1 % num2;
            default -> {
                System.out.println("Invalid operator!");
                yield Double.NaN;
            }
        };

        System.out.println("Result: " + result);
        sc.close();
    }
}
