/*
 * Implementation of a stack backed by an array.
 */
public class ArrayStack implements StackInterface {

    private int[] stackArr;
    private int size;
    private int capacity;
    private static final int MIN_CAPACITY = 50;

    public ArrayStack() {
        stackArr = new int[MIN_CAPACITY];
        size = 0;
        capacity = MIN_CAPACITY;
    }

    public ArrayStack(ArrayStack copy) {
        this.stackArr = copy.stackArr.clone();
        this.size = copy.size;
        this.capacity = copy.capacity;
    }

    public void push(int value) {
        if (isFull()) {
            doubleCapacity();
        }
        stackArr[size] = value;
        size++;
    }

    public int pop() {
        int result = stackArr[size - 1];
        int[] temp = new int[capacity];
        for (int i = 0; i < size - 1; i++) {
            temp[i] = stackArr[i];
        }
        stackArr = new int[capacity];
        for (int i = 0; i < size - 1; i++) {
            stackArr[i] = temp[i];
        }
        size--;
        return result;
    }

    public int peek() {
        return stackArr[size - 1];
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
            temp[i] = stackArr[i];
        }
        stackArr = new int[capacity];
        for (int i = 0; i < size; i++) {
            stackArr[i] = temp[i];
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        stackArr = new int[MIN_CAPACITY];
        size = 0;
        capacity = MIN_CAPACITY;
    }

    public String toString() {
        String result = "{";
        for (int i = 0; i < size - 1; i++) {
            result += Integer.toString(stackArr[i]) + ",";
        }
        result += Integer.toString(stackArr[size - 1]) + "}";
        return result;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ArrayStack)) {
            return false;
        }
        ArrayStack temp = (ArrayStack) obj;
        if (size != temp.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (stackArr[i] != temp.stackArr[i]) {
                return false;
            }
        }
        return true;
    }
}
