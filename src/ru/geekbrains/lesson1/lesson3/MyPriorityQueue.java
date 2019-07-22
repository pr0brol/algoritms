package ru.geekbrains.lesson1.lesson3;

import java.util.Comparator;

public class MyPriorityQueue<T extends Comparable> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    //
    private Comparator comparator = Comparator.naturalOrder();

    public MyPriorityQueue(int capacity, Comparator comparator) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (T[]) new Comparable[capacity];
            this.comparator = comparator;
        }
    }

    public MyPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (T[]) new Comparable[capacity];
        }
    }

    public MyPriorityQueue() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void insert(T item) {
        if (isFull()) {
            reCapacity(list.length * 2);
        }
        list[size] = item;
        size++;
        int i = size - 1;
        while (i > 0 && comparator.compare(list[i], list[i - 1]) < 0) {
            swap(i, i - 1);
            i--;
        }
    }

    public T remove() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }


    public T peek() {
        if (isEmpty()) {
            System.out.println("stack empty");
            return null;
        }
        if(size < list.length / 2){
            reCapacity(list.length / 2);
        }
        return list[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list = tempArr;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < list.length; i++) {
            s += list[i] + " ";
        }
        return s;
    }
}
