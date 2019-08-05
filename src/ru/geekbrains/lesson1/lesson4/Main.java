package ru.geekbrains.lesson1.lesson4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyDoubleLinkedList<String> list = new MyDoubleLinkedList<>();

        list.insertFirst("Ivan");
        list.insertFirst("Petr");
        list.insertFirst("Julia");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
        System.out.println(list.toString());
        iterator.remove();
        System.out.println(list.toString());


    }
}
