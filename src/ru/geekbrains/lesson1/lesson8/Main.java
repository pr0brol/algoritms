package ru.geekbrains.lesson1.lesson8;

public class Main {
    public static void main(String[] args) {
        ChainingHashMap<Integer, String> hm = new ChainingHashMap<>();

        LinearProbingHashMap<Integer, String> lhm = new LinearProbingHashMap<>();

        hm.put(1, "one");
        hm.put(2, "two");
        hm.put(3, "three");
        hm.put(4, "four");
        hm.put(5, "five");
        hm.put(6, "one-one");
        hm.put(7, "two-two");
        hm.put(8, "three-three");

        System.out.println(hm.remove(6));
        System.out.println(hm.get(6));
    }
}
