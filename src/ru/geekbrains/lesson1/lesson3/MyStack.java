package ru.geekbrains.lesson1.lesson3;

public class MyStack<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (T[]) new Object[capacity];
        }
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T item) {
        if (isFull()) {
            reCapacity(list.length * 2);
        }
        list[size] = item;
        size++;
    }

    public T pop() {
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
