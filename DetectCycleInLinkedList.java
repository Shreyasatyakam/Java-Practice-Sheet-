import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Detect cycle using Floyd’s Algorithm
    boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          
            fast = fast.next.next;    

            if (slow == fast) {
                return true;          
            }
        }
        return false;
    }

    void createCycle(int pos) {
        if (head == null) return;

        Node temp = head;
        Node cycleNode = null;
        int count = 1;

        while (temp.next != null) {
            if (count == pos) {
                cycleNode = temp;
            }
            temp = temp.next;
            count++;
        }

        if (cycleNode != null) {
            temp.next = cycleNode;
            System.out.println("Cycle created at node with value: " + cycleNode.data);
        } else {
            System.out.println("Invalid position for cycle creation.");
        }
    }
}

public class DetectCycleInLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        while (true) {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Insert Node");
            System.out.println("2. Create Cycle");
            System.out.println("3. Detect Cycle");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    list.insert(val);
                }
                case 2 -> {
                    System.out.print("Enter position to connect last node (starting from 1): ");
                    int pos = sc.nextInt();
                    list.createCycle(pos);
                }
                case 3 -> {
                    if (list.hasCycle()) {
                        System.out.println(" Cycle detected in the linked list!");
                    } else {
                        System.out.println("No cycle found.");
                    }
                }
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
