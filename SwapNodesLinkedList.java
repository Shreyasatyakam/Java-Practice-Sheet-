import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class SwapNodesLinkedList {

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // Swapping nodes
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move pointers
            prev = first;
            head = first.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter values:");
        ListNode head = null, tail = null;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode node = new ListNode(val);
            if (head == null) head = node;
            else tail.next = node;
            tail = node;
        }

        System.out.print("Original list: ");
        printList(head);

        head = swapPairs(head);

        System.out.print("Swapped list: ");
        printList(head);
    }
}
