import java.math.BigInteger;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (!(l1 == null && l2 == null)) {
            if (l1 != null) {
                sb1.insert(0, l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                sb2.insert(0, l2.val);
                l2 = l2.next;
            }
        }

        BigInteger bi1 = new BigInteger(sb1.toString());
        BigInteger bi2 = new BigInteger(sb2.toString());
        BigInteger bi3 = bi1.add(bi2);
        StringBuilder sb3 = new StringBuilder(bi3.toString());
        ListNode head = new ListNode();
        ListNode prev = null;
        ListNode current = null;

        for (int i = sb3.length() - 1; i >= 0; i--) {
            if (i == sb3.length() - 1) {
                current = new ListNode(Integer.parseInt(Character.toString(sb3.charAt(i))));
                head = current;
                prev = current;
                continue;
            }

            current = new ListNode(Integer.parseInt(Character.toString(sb3.charAt(i))));
            prev.next = current;
            prev = current;
        }

        return head;
    }
}
