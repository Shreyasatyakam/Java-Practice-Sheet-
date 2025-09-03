import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // synchronized to avoid race conditions
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() +
                " deposited " + amount + " | Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() +
                    " withdrew " + amount + " | Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " tried to withdraw " + amount + " but insufficient balance!");
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class BankAccountTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input initial balance
        System.out.print("Enter initial balance: ");
        int initialBalance = sc.nextInt();
        BankAccount account = new BankAccount(initialBalance);

        // Input deposit operations
        System.out.print("Enter number of deposits: ");
        int depositOps = sc.nextInt();
        System.out.print("Enter deposit amount: ");
        int depositAmount = sc.nextInt();

        // Input withdraw operations
        System.out.print("Enter number of withdrawals: ");
        int withdrawOps = sc.nextInt();
        System.out.print("Enter withdraw amount: ");
        int withdrawAmount = sc.nextInt();

        // Thread for deposits
        Thread depositor = new Thread(() -> {
            for (int i = 0; i < depositOps; i++) {
                account.deposit(depositAmount);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        }, "Depositor");

        // Thread for withdrawals
        Thread withdrawer = new Thread(() -> {
            for (int i = 0; i < withdrawOps; i++) {
                account.withdraw(withdrawAmount);
                try { Thread.sleep(120); } catch (InterruptedException e) {}
            }
        }, "Withdrawer");

        // Start threads
        depositor.start();
        withdrawer.start();

        // Wait for threads to finish
        try {
            depositor.join();
            withdrawer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance = " + account.getBalance());
        sc.close();
    }
}
