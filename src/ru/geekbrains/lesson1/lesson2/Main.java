package ru.geekbrains.lesson1.lesson2;

public class Main {
    public static void main(String[] args) {
        int SIZE_ARRAY = 1000000;
        ArrayObject<Integer> nums = new ArrayObject<>(SIZE_ARRAY);

        for (int i = 0; i < SIZE_ARRAY; i++) {
            nums.add((int)(Math.random()*10));
        }

        long start = System.currentTimeMillis();
        nums.insertionSort();
        System.out.println("время выполнения insertionSort(): " + (System.currentTimeMillis() - start));

        for (int i = 0; i < SIZE_ARRAY; i++) {
            nums.set(i, (int)(Math.random()*10));
        }

        start = System.currentTimeMillis();
        nums.selectionSort();
        System.out.println("время выполнения selectionSort(): " + (System.currentTimeMillis() - start));

        for (int i = 0; i < SIZE_ARRAY; i++) {
            nums.set(i, (int)(Math.random()*10));
        }

        start = System.currentTimeMillis();
        nums.bubbleSort();
        System.out.println("время выполнения bubbleSort(): " + (System.currentTimeMillis() - start));
    }
}
