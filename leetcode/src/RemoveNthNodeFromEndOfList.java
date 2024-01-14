import java.util.Stack;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        Stack<ListNode> nLastNodes = new Stack<>();

        ListNode node = head;
        nLastNodes.add(node);
        while (node.next != null) {
            node = node.next;
            nLastNodes.add(node);
        }

        ListNode toBeDeleted = null;
        ListNode prevNode = null;
        for (int i = 0; i < n; i++) {
            toBeDeleted = nLastNodes.pop();
        }

        if (!nLastNodes.isEmpty()) {
            prevNode = nLastNodes.pop();
        } else {
            return head.next;
        }

        if (toBeDeleted != null) {
            prevNode.next = toBeDeleted.next;
        }

        return head;
    }
}
