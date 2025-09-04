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

    // Insert node at end
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

    // Find middle using slow and fast pointers
    int findMiddle() {
        if (head == null) throw new IllegalStateException("List is empty");

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // move by 1
            fast = fast.next.next;    // move by 2
        }
        return slow.data; // middle node
    }

    // Print linked list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class FindMiddleOfLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        while (true) {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Insert Node");
            System.out.println("2. Display List");
            System.out.println("3. Find Middle");
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
                    System.out.print("List: ");
                    list.display();
                }
                case 3 -> {
                    try {
                        int middle = list.findMiddle();
                        System.out.println("Middle element: " + middle);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
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
