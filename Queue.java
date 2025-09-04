import java.util.Scanner;

class Queue {
    private int[] arr;
    private int front, rear, capacity, count;

    // Constructor
    public Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Enqueue operation
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot insert " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
        System.out.println(item + " enqueued.");
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Nothing to dequeue.");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return arr[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return (count == 0);
    }

    // Check if queue is full
    public boolean isFull() {
        return (count == capacity);
    }

    // Print queue elements
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

public class CustomQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();
        Queue queue = new Queue(size);

        while (true) {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Print Queue");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter number to enqueue: ");
                    int num = sc.nextInt();
                    queue.enqueue(num);
                }
                case 2 -> {
                    int removed = queue.dequeue();
                    if (removed != -1)
                        System.out.println("Dequeued: " + removed);
                }
                case 3 -> System.out.println("Front element: " + queue.peek());
                case 4 -> queue.printQueue();
                case 5 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }
}
