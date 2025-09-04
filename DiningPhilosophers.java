import java.util.concurrent.locks.ReentrantLock;

class Philosopher implements Runnable {
    private final int id;
    private final ReentrantLock leftFork;
    private final ReentrantLock rightFork;

    public Philosopher(int id, ReentrantLock leftFork, ReentrantLock rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();

                // Pick up left fork
                if (leftFork.tryLock()) {
                    try {
                        // Pick up right fork
                        if (rightFork.tryLock()) {
                            try {
                                eat();
                            } finally {
                                rightFork.unlock(); // put down right fork
                            }
                        }
                    } finally {
                        leftFork.unlock(); // put down left fork
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Philosopher " + id + " was interrupted.");
        }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Thread[] philosophers = new Thread[numPhilosophers];
        ReentrantLock[] forks = new ReentrantLock[numPhilosophers];

        // Initialize forks
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new ReentrantLock();
        }

        // Initialize philosophers
        for (int i = 0; i < numPhilosophers; i++) {
            ReentrantLock leftFork = forks[i];
            ReentrantLock rightFork = forks[(i + 1) % numPhilosophers];

            philosophers[i] = new Thread(new Philosopher(i, leftFork, rightFork));
            philosophers[i].start();
        }
    }
}
