public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode secondHead = head.next;

        ListNode odd = head;
        ListNode even = head.next;

        while (true) {
            if (odd.next.next == null) break;
            ListNode oddNextNext = odd.next.next;
            odd.next = oddNextNext;
            odd = oddNextNext;
            if (even.next.next == null) {
                even.next = null;
                break;
            }
            ListNode evenNextNext = even.next.next;
            even.next = evenNextNext;
            even = evenNextNext;
        }

        odd.next = secondHead;
        return head;
    }

    private ListNode[] getSublistStartEnd(ListNode prev, int size) {
        ListNode[] startEnd = new ListNode[2];
        if (prev.next == null) {
            return startEnd;
        }
        ListNode head = prev.next;
        ListNode tail;
        startEnd[0] = head;
        if (size == 1) {
            startEnd[1] = head;
        }

        for (int i = 0; i < size - 1; i++) {
            head = head.next;
            if (head == null) break;
            if (i == size - 2) startEnd[1] = head;
        }

        return startEnd;
    }
}
