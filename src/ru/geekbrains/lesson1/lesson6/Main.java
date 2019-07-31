package ru.geekbrains.lesson1.lesson6;

public class Main {
    public static void main(String[] args) {

        int COUNT_ARRAY = 1000000;
        int COUNT_ARRAY_BALANCE = 0;
        for (int i = 0; i < COUNT_ARRAY; i++) {
            BST<Integer> bst = new BST<>();
            while (bst.depth() < 7){
                bst.put((int) (Math.random() * 200 - 100));
            }
//            System.out.println(bst.leftDepth() + " " + bst.rightDepth());
            if(bst.leftDepth() == bst.rightDepth()){

                COUNT_ARRAY_BALANCE++;
            }
        }

        System.out.println(COUNT_ARRAY_BALANCE);
    }
}
