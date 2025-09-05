import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        for (int i = 0; i <= n; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of linked list: ");
        int n = sc.nextInt();
        ListNode head = null, tail = null;

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (head == null) {
                head = tail = new ListNode(x);
            } else {
                tail.next = new ListNode(x);
                tail = tail.next;
            }
        }

        System.out.print("Enter N (to remove from end): ");
        int k = sc.nextInt();

        head = removeNthFromEnd(head, k);

        System.out.print("Updated List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
