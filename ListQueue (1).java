public class ListQueue implements QueueInterface {

    private class Node {

        private int val;
        private Node next;

        Node(int value) {
            val = value;
            next = null;
        }

    }

    private int size;
    private Node prevNode;
    private Node nextNode;

    public ListQueue() {
        size = 0;
        prevNode = null;
        nextNode = null;
    }

    public ListQueue(ListQueue copy) {
        size = copy.size;
        prevNode = copy.prevNode;
        nextNode = copy.nextNode;
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (nextNode == null) {
            prevNode = node;
            nextNode = node;
        } else {
            nextNode.next = node;
            nextNode = node;
        }
        size++;
    }

    public int dequeue() {
        int result = prevNode.val;
        prevNode = prevNode.next;
        size--;
        return result;
    }

    public int peek() {
        return prevNode.val;
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
        size = 0;
        prevNode = null;
        nextNode = null;
    }

    public String toString() {
        Node temp = prevNode;
        String result = "";
        for (int i = 0; i < size - 1; i++) {
            result += Integer.toString(temp.val) + ",";
            temp = temp.next;
        }
        result += Integer.toString(temp.val);
        return "{" + result + "}";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ListQueue)) {
            return false;
        }
        ListQueue temp = (ListQueue) obj;
        if (size != temp.size) {
            return false;
        }
        Node tempNode = prevNode;
        for (int i = 0; i < size; i++) {
            if (tempNode.val != temp.prevNode.val) {
                return false;
            }
            tempNode = tempNode.next;
            temp.prevNode = temp.prevNode.next;
        }
        return true;
    }

}
