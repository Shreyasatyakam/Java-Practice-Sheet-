import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class ATMSimulator {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 5000.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();
            if (pin != CORRECT_PIN) {
                throw new InvalidPinException(" Invalid PIN. Access Denied!");
            }

            while (true) {
                System.out.println("\n=== ATM MENU ===");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> System.out.println(" Current Balance: ₹" + balance);

                    case 2 -> {
                        System.out.print("Enter amount to deposit: ₹");
                        double deposit = sc.nextDouble();
                        if (deposit <= 0) {
                            throw new IllegalArgumentException(" Deposit amount must be positive.");
                        }
                        balance += deposit;
                        System.out.println("Successfully deposited ₹" + deposit);
                    }

                    case 3 -> {
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdraw = sc.nextDouble();
                        if (withdraw <= 0) {
                            throw new IllegalArgumentException(" Withdrawal amount must be positive.");
                        }
                        if (withdraw > balance) {
                            throw new InsufficientFundsException(" Insufficient Balance.");
                        }
                        balance -= withdraw;
                        System.out.println(" Successfully withdrew ₹" + withdraw);
                    }

                    case 4 -> {
                        System.out.println(" Thank you for using the ATM!");
                        sc.close();
                        return;
                    }

                    default -> System.out.println(" Invalid option. Try again.");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println(" Invalid input. Please enter numbers only.");
        } catch (InvalidPinException | InsufficientFundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
