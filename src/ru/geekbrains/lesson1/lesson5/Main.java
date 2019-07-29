package ru.geekbrains.lesson1.lesson5;

public class Main {
    public static void main(String[] args) {
        System.out.println(recExpo(2, 10));
    }

    public static double recExpo(double a, int n) {
        if (n <= 1) {
            return a;
        } else {
            return recExpo(a, n - 1) * a;
        }
    }
}
