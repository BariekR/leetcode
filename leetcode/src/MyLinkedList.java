public class MyLinkedList {
    private SinglyListNode head;

    public MyLinkedList() {

    }

    public int get(int index) {
        SinglyListNode node = getNode(index);

        if (node == null) {
            return -1;
        }

        return node.val;
    }

    private SinglyListNode getNode(int index) {
        if (head == null || index < 0) {
            return null;
        }

        SinglyListNode node = head;
        for (int i = 0; i < index; i++) {
            if (node.next == null) {
                return null;
            } else {
                node = node.next;
            }
        }

        return node;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new SinglyListNode(val);
        } else {
            SinglyListNode node = new SinglyListNode(val);
            node.next = head;
            head = node;
        }
    }

    public void addAtTail(int val) {
        SinglyListNode node = new SinglyListNode(val);

        if (head == null) {
            head = node;
            return;
        }

        SinglyListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || (head == null && index != 0)) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        SinglyListNode node = new SinglyListNode(val);
        SinglyListNode prev = getNode(index - 1);

        if (prev == null) {
            return;
        } else if (prev.next == null) {
            prev.next = node;
        } else {
            node.next = prev.next;
            prev.next = node;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || head == null) {
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        SinglyListNode prev = getNode(index - 1);
        if (prev == null) {
            return;
        } else {
            SinglyListNode toBeDeleted = prev.next;
            if (toBeDeleted == null) {
                return;
            } else {
                prev.next = toBeDeleted.next;
            }
        }
    }
}
