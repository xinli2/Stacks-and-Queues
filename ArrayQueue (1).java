
/*
 * Implementation of a queue backed by an array.
 */
public class ArrayQueue implements QueueInterface {

    private int[] queueArr;
    private int size;
    private int capacity;
    private static final int MIN_CAPACITY = 50;

    public ArrayQueue() {
        queueArr = new int[MIN_CAPACITY];
        size = 0;
        capacity = MIN_CAPACITY;
    }

    public ArrayQueue(ArrayQueue copy) {
        queueArr = copy.queueArr;
        size = copy.size;
        capacity = copy.capacity;
    }

    public void enqueue(int value) {
        if (isFull()) {
            doubleCapacity();
        }
        queueArr[size] = value;
        size++;
    }

    public int dequeue() {
        int result = queueArr[0];
        int[] temp = new int[capacity];
        for (int i = 1; i < size; i++) {
            temp[i - 1] = queueArr[i];
        }
        queueArr = new int[capacity];
        for (int i = 0; i < size; i++) {
            queueArr[i] = temp[i];
        }
        size--;
        return result;
    }

    public int peek() {
        return queueArr[0];
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    private boolean isFull() {
        if (size == capacity) {
            return true;
        }
        return false;
    }

    private void doubleCapacity() {
        capacity *= 2;
        int[] temp = new int[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queueArr[i];
        }
        queueArr = new int[capacity];
        for (int i = 0; i < size; i++) {
            queueArr[i] = temp[i];
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        queueArr = new int[MIN_CAPACITY];
        size = 0;
        capacity = MIN_CAPACITY;
    }

    public String toString() {
        String result = "{";
        for (int i = 0; i < size - 1; i++) {
            result += Integer.toString(queueArr[i]) + ",";
        }
        result += Integer.toString(queueArr[size - 1]) + "}";
        return result;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ArrayQueue)) {
            return false;
        }
        ArrayQueue temp = (ArrayQueue) obj;
        if (size != temp.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (queueArr[i] != temp.queueArr[i]) {
                return false;
            }
        }
        return true;
    }

}
