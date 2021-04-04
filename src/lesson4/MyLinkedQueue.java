package lesson4;

public class MyLinkedQueue<T> {

    private MyLinkedList<T> ll2 = new MyLinkedList<>();

    public void push(T item) {
        ll2.insertLast(item);
    }

    public T peekFront() {
        return ll2.getFirst();
    }

    public T pop() {
        return ll2.removeFirst();
    }

    public int size() {
        return ll2.size();
    }

    public boolean isEmpty() {
        return ll2.isEmpty();
    }
}
