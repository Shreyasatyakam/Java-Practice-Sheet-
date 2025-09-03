import java.util.*;

public class BinaryDecimalConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose conversion:");
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Binary");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter a binary number: ");
                String binary = sc.next();
                int decimal = Integer.parseInt(binary, 2); // base 2
                System.out.println("Decimal value = " + decimal);
            }
            case 2 -> {
                System.out.print("Enter a decimal number: ");
                int decimal = sc.nextInt();
                String binary = Integer.toBinaryString(decimal); // convert to base 2
                System.out.println("Binary value = " + binary);
            }
            default -> System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
