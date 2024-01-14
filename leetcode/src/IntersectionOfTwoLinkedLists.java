import java.util.HashMap;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> nodesA = new HashMap<>();
        if (headA == headB) return headA;

        ListNode node = headA;
        nodesA.put(node, 1);
        while (node.next != null) {
            node = node.next;
            nodesA.put(node, 1);
        }

        node = headB;
        while (true) {
            if (nodesA.containsKey(node)) {
                return node;
            }
            if (node.next != null) {
                node = node.next;
            } else {
                break;
            }
        }

        return null;
    }
}
