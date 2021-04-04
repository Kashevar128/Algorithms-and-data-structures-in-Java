package lesson4;

public class MyLinkedStack<T> {
    private MyLinkedList<T> ll = new MyLinkedList<>();

    public void push(T item) {
        ll.insertLast(item);
    }

    public T peek() {
        return ll.getLast();
    }

    public T pop() {
        return ll.removeLast();
    }

    public int size() {
        return ll.size();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }
}
