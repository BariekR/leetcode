public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode ln5 = new ListNode(5, null);
        ListNode ln4 = new ListNode(4, ln5);
        ListNode ln3 = new ListNode(3, ln4);
        ListNode ln2 = new ListNode(2, ln3);
        ListNode ln1 = new ListNode(1, ln2);

        reverseList(ln1);
    }

    public static ListNode reverseList(ListNode head) {
        /*if (head.next == null) {
            return head;
        }
        ListNode temp = reverseList(head.next);
        temp.next = head;
        return head;*/

        if (head == null || head.next == null) {
            return head;
        }

        ListNode hNext = head.next;
        ListNode last = reverseList(head.next);
        hNext.next = head;
        head.next = null;
        return last;
    }
}
