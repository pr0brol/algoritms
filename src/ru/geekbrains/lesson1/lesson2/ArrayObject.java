package ru.geekbrains.lesson1.lesson2;

public class ArrayObject<T extends Comparable> {
    private T[] list;
    private int size;
    private int DEFAULT_CAPACITY = 10;

    public ArrayObject(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (T[]) new Comparable[capacity];
        }
    }

    public ArrayObject() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void add(T obj) {
        list[size] = obj;
        size++;
    }

    public void add(int index, T obj) {
        if (index > size) {
            index = size;
        }
        if (index < 0) {
            index = 0;
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = obj;
        size++;
    }

    public boolean remove(T obj) {
        int i = 0;
        while (i < size && !list.equals(obj)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        size--;
        list[size] = null;
        return true;
    }

    public boolean find(T obj){
        for (int i = 0; i < size; i++) {
            if(list[i].equals(obj)){
                return true;
            }
        }
        return false;
    }

    public void set(int index, T obj) {
        list[index] = obj;
    }

    private boolean less(T obj1, T obj2) {
        return obj1.compareTo(obj2)< 0;
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

    public void bubbleSort(){
        boolean isSwap;
        for (int i = size-1; i >0 ; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if(less(list[j+1], list[j])){
                    swap(j+1,j);
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }
}
