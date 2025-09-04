import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet(); // atomically increment by 1
    }

    public void decrement() {
        count.decrementAndGet(); // atomically decrement by 1
    }

    public int getValue() {
        return count.get(); // atomically get current value
    }
}

public class AtomicCounterDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create 2 threads that increment the counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        System.out.println("Final Counter Value: " + counter.getValue());
    }
}
