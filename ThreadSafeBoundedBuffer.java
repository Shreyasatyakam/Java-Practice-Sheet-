import java.util.LinkedList;
import java.util.Scanner;

// Thread-safe bounded buffer
class BoundedBuffer<T> {
    private final LinkedList<T> buffer = new LinkedList<>();
    private final int capacity;

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
    }

    // Add item to buffer
    public synchronized void put(T item) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait(); // wait if buffer is full
        }
        buffer.add(item);
        notifyAll(); // notify waiting consumers
    }

    // Remove item from buffer
    public synchronized T take() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // wait if buffer is empty
        }
        T item = buffer.removeFirst();
        notifyAll(); // notify waiting producers
        return item;
    }

    public synchronized int size() {
        return buffer.size();
    }
}

// Producer thread
class Producer extends Thread {
    private final BoundedBuffer<Integer> buffer;

    public Producer(BoundedBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                buffer.put(i);
                System.out.println("Produced: " + i + " | Buffer size: " + buffer.size());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Consumer thread
class Consumer extends Thread {
    private final BoundedBuffer<Integer> buffer;

    public Consumer(BoundedBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                int item = buffer.take();
                System.out.println("Consumed: " + item + " | Buffer size: " + buffer.size());
                Thread.sleep(150);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Main class
public class ThreadSafeBoundedBuffer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter buffer capacity: ");
        int capacity = sc.nextInt();

        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(capacity);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
