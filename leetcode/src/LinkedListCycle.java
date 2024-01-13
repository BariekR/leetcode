public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (slow.next != null) {
                slow = slow.next;
            } else {
                return false;
            }
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (fast == slow) {
                return true;
            }
        }
    }
}
