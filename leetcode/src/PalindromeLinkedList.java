import java.util.ArrayList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> nodes = new ArrayList<>();
        nodes.add(head.val);

        while (true) {
            if (head.next != null) {
                nodes.add(head.next.val);
                head = head.next;
            } else {
                break;
            }
        }

        for (int i = 0; i < nodes.size()/2; i++) {
            if (!nodes.get(i).equals(nodes.get(nodes.size() - 1 - i))) {
                return false;
            }
        }

        return true;
    }
}
