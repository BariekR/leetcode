public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode previous = null;
        ListNode current = head;

        while (true) {
            if (current.val == val) {
                if (current.next == null) {
                    if (previous != null) {
                        previous.next = null;
                        return head;
                    } else {
                        return null;
                    }
                } else {
                    if (previous != null) {
                        previous.next = current.next;
                        current = current.next;
                    } else {
                        head = current.next;
                        current = head;
                    }
                }
            } else {
                if (current.next == null) {
                    return head;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        }
    }
}
