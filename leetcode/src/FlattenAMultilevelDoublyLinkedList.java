public class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        helper(head);

        return head;
    }

    private Node helper(Node head) {
        if (head.child != null) {
            if (head.next != null) {
                Node oldHeadNext = head.next;
                head.next = head.child;
                head.child = null;
                head.next.prev = head;
                Node lastChild = helper(head.next);
                oldHeadNext.prev = lastChild;
                lastChild.next = oldHeadNext;
            } else {
                head.next = head.child;
                head.child = null;
                head.next.prev = head;
            }
        }

        if (head.next != null) {
            return helper(head.next);
        } else {
            return head;
        }
    }
}
