class SharedPrinter {
    private boolean isOddTurn = true;

    public synchronized void printOdd(int number) {
        while (!isOddTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Odd: " + number);
        isOddTurn = false;
        notify();
    }

    public synchronized void printEven(int number) {
        while (isOddTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Even: " + number);
        isOddTurn = true;
        notify();
    }
}

class OddThread extends Thread {
    private final SharedPrinter printer;
    private final int limit;

    OddThread(SharedPrinter printer, int limit) {
        this.printer = printer;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i += 2) {
            printer.printOdd(i);
        }
    }
}

class EvenThread extends Thread {
    private final SharedPrinter printer;
    private final int limit;

    EvenThread(SharedPrinter printer, int limit) {
        this.printer = printer;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 2; i <= limit; i += 2) {
            printer.printEven(i);
        }
    }
}

public class OddEvenPrinter {
    public static void main(String[] args) {
        int limit = 10; // you can change this or take input
        SharedPrinter printer = new SharedPrinter();

        Thread oddThread = new OddThread(printer, limit);
        Thread evenThread = new EvenThread(printer, limit);

        oddThread.start();
        evenThread.start();
    }
}
