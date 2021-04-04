package lesson3;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public T[] getList() {
        return list;
    }

    MyDeque(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    MyDeque() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];
    }

    /**
     * Метод добавления в очередь нового элемента
     *
     * @param item добавляемый элемент
     * @throws IllegalStateException если очередь полная
     */
    public void insertEnd(T item) {
        if (isFull()) {
            throw new StackOverflowError("Дек заполнен");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T removeEnd() {
        T temp = peek();
        size--;
        end = previousIndex(end);
        list[end] = null;
        return temp;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public void insertBegin(T item) {
        if (isFull()) {
            throw new StackOverflowError("Дек заполнен");
        }
        size++;
        begin = previousIndex(begin);
        list[begin] = item;
    }

    public T removeBegin() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int previousIndex(int index) {
        index -= 1;
        if(index < 0) index = capacity - 1;
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append(list[i] + " ");
        }
        return sb.toString();
    }


}
