public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode node;
        if (list1 == null) {
            node = list2;
            node.next = mergeTwoLists(list1, list2.next);
        } else if (list2 == null) {
            node = list1;
            node.next = mergeTwoLists(list1.next, list2);
        } else if (list1.val <= list2.val) {
            node = list1;
            node.next = mergeTwoLists(list1.next, list2);
        } else {
            node = list2;
            node.next = mergeTwoLists(list1, list2.next);
        }

        return node;
    }
}
