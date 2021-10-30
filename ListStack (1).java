/*
 * Implementation of a stack backed by a linked list.
 */
public class ListStack implements StackInterface {

    private class Node {

        private int val;
        private Node next;

        Node(int value) {
            val = value;
            next = null;
        }

    }

    private int size;
    private Node cur;

    public ListStack() {
        cur = null;
        size = 0;
    }

    public ListStack(ListStack copy) {
        cur = copy.cur;
        size = copy.size;
    }

    public void push(int value) {
        Node node = new Node(value);
        if (cur == null) {
            cur = node;
        } else {
            node.next = cur;
            cur = node;
        }
        size++;
    }

    public int pop() {
        int result = cur.val;
        cur = cur.next;
        size--;
        return result;
    }

    public int peek() {
        return cur.val;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        cur = null;
        size = 0;
    }

    public String toString() {
        Node temp = cur;
        String result = Integer.toString(temp.val);
        for (int i = 0; i < size - 1; i++) {
            temp = temp.next;
            result = Integer.toString(temp.val) + "," + result;
        }
        return "{" + result + "}";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ListStack)) {
            return false;
        }
        ListStack temp = (ListStack) obj;
        if (size != temp.size) {
            return false;
        }
        Node tempNode = cur;
        for (int i = 0; i < size; i++) {
            if (tempNode.val != temp.cur.val) {
                return false;
            }
            tempNode = tempNode.next;
            temp.cur = temp.cur.next;
        }
        return true;
    }

}
