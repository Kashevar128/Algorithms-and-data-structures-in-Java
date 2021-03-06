package Lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private final double LOAD_FACTOR = 0.75;

    public int getCapacity() {
        return capacity;
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <=0 " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Comparable[capacity];
    }

    public void checkLoadFactor() {
        double loadFactor = (double) size / capacity;
        if (loadFactor > LOAD_FACTOR) {
            capacity = (int) (capacity * 1.5);
            T[] newList = (T[]) new Comparable[capacity];
            for (int i = 0; i < size; i++) {
                newList[i] = list[i];
            }
            list = newList;
        }
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= capacity) throw new RuntimeException("Недопустимое значение индекса: " + index );
    }

    public void add(T item) {
        checkLoadFactor();
        // доделать проверку на превышение лоад фактора 0.75
        if (size == capacity) throw new RuntimeException("Массив переполнен");
        list[size] = item;
        size++;
    }

    public void add(int index, T item) {
        checkLoadFactor();
        checkIndex(index);
        // доделать проверку на превышение лоад фактора 0.75
        // доделать проверку на допустимость индекса
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public final T remove(int index) {
        // доделать проверку на допустимость индекса
        checkIndex(index);
        T temp = list[index];
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
        list[size] = null;
        return temp;
    }

    public boolean remove(T item) {
        int i = indexOf(item);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int index) {
        checkIndex(index);
        // доделать проверку на допустимость индекса
        return list[index];
    }

    public void set(int index, T item) {
        checkIndex(index);
        // доделать проверку на допустимость индекса

        list[index] = item;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }

        sb.append(" ]");
        return sb.toString();
    }


    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                }
            }
        }
    }

    public void bubbleSortO() {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    public void quickSort (int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        T opora = list[mid];

        int i = lo;
        int j = hi;
        while(i <= j) {
            while (less(list[i], opora)) {
                i++;
            }
            while (less(opora, list[j])) {
                j--;
            }
            if(i <= j) {
                swap(i, j);
                i++;
                j--;
            }

            if(lo < j) {
                quickSort(lo, j);
            }
            if(hi > i) {
                quickSort(i, hi);
            }
        }
    }
}
