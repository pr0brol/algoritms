package ru.geekbrains.lesson1.lesson3;

public class MyDecue<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    public MyDecue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (T[]) new Object[capacity];
        }
    }

    public MyDecue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertRight(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertLeft(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        if(begin == 0){
            begin = list.length;
        }
        list[begin - 1] = item;
        begin--;

    }

    public T removeRight() {
        T value = peekRight();
        size--;

        list[end] = null;
        return value;
    }

    public T removeLeft() {
        T value = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    public T peekLeft() {
        if (isEmpty()) {
            return null;
        }
        return list[begin];
    }

    public T peekRight() {
        if (isEmpty()) {
            return null;
        }
        if(end == 0){
            end = list.length - 1;
        }else {
            end = previousIndex(end);
        }
        return list[end];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int previousIndex(int index) {
        return (index - 1) % list.length;
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