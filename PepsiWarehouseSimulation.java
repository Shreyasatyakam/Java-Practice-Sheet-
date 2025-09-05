import java.util.*;

class Warehouse {
    private final Queue<String> buffer = new LinkedList<>();
    private final int capacity;

    public Warehouse(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(String product) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait(); // warehouse is full
        }
        buffer.add(product);
        System.out.println("Produced: " + product + " | Stock: " + buffer.size());
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // warehouse empty
        }
        String product = buffer.poll();
        System.out.println("Consumed: " + product + " | Stock: " + buffer.size());
        notifyAll();
    }
}

class Producer extends Thread {
    private final Warehouse warehouse;
    private final String[] products = {"Pepsi", "Lays", "MountainDew", "Gatorade"};

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void run() {
        Random rand = new Random();
        try {
            while (true) {
                String product = products[rand.nextInt(products.length)];
                warehouse.produce(product);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

class Consumer extends Thread {
    private final Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void run() {
        try {
            while (true) {
                warehouse.consume();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

public class PepsiWarehouseSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter warehouse capacity: ");
        int cap = sc.nextInt();

        Warehouse warehouse = new Warehouse(cap);

        Producer p1 = new Producer(warehouse);
        Producer p2 = new Producer(warehouse);
        Consumer c1 = new Consumer(warehouse);
        Consumer c2 = new Consumer(warehouse);

        p1.start(); p2.start();
        c1.start(); c2.start();
    }
}
