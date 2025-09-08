import java.util.Scanner;

class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.rear = this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("❌ Queue is full. Cannot insert " + value);
            return;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println("✅ Inserted " + value);
    }


    public void dequeue() {
        if (isEmpty()) {
            System.out.println("❌ Queue is empty. Nothing to remove.");
            return;
        }
        int removed = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("✅ Removed " + removed);
    }

 
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

public class CircularQueueDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter capacity of Circular Queue: ");
        int capacity = sc.nextInt();

        CircularQueue cq = new CircularQueue(capacity);

        while (true) {
            System.out.println("\n--- Circular Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    cq.enqueue(val);
                }
                case 2 -> cq.dequeue();
                case 3 -> cq.display();
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
