package ru.geekbrains.lesson1.lesson3;

public class Main {
    public static void main(String[] args) {
        String string = "This is a test string";
        MyStack<String> str = new MyStack<>(string.length());
        for(char s: string.toCharArray()) {
            str.push(String.valueOf(s));
        }
        System.out.println(str.toString());

        for (int i = 0; i < string.length(); i++) {
            System.out.print(str.pop() + " ");
        }
        System.out.println();

        MyStack<Integer> num = new MyStack<>(5);
        num.push(1);
        num.push(2);
        num.push(3);
        num.push(4);
        num.push(5);
        System.out.println(num.toString());
        num.push(6);
        System.out.println(num.toString());
    }
}

