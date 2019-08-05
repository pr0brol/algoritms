package ru.geekbrains.lesson1.lesson3;

public class MyQueue<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (T[]) new Object[capacity];
        }
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insert(T item) {
        if (isFull()) {
            reCapacity(list.length * 2);
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T remove() {
        T value = peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        if(size < list.length / 2){
            reCapacity(list.length / 2);
        }
        return list[begin];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
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

    private void reCapacity( int newCapacity){
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list,0,tempArr,0,size);
        list = tempArr;
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