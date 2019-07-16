package ru.geekbrains.lesson1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while (true){
            if(N < 2 || N > 10000){
                System.out.println("NO");
                break;
            }else if(N == 2){
                System.out.println("YES");
                break;
            }else {
                if(N % 2 != 0){
                    System.out.println("NO");
                    break;
                }
                N /= 2;
            }
        }
    }
}
