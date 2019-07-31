package ru.geekbrains.lesson1.lesson6;

import java.util.NoSuchElementException;

public class BST<T extends Comparable<T>> {
    private Node root;

    public class Node {
        private T item;
        public Node left;
        public Node right;
        private int size;
        public int depth;

        public Node(T item) {
            this.item = item;
            size = 1;
            depth = 1;
        }
    }

    public Node getNode(){
        return root;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int depth(){return depth(root);}

    public int leftDepth(){
        return depth(root.left);
    }

    public int rightDepth(){
        return depth(root.right);
    }

    private int depth(Node node){
        if(node == null){
            return 0;
        }
        return node.depth;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isKeyNotNull(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }
        return true;
    }

    public boolean contains(T item) {
        isKeyNotNull(item);
        return get(item) != null;
    }

    public T get(T item) {
        return get(root, item);
    }

    private T get(Node node, T item) {
        isKeyNotNull(item);
        if (node == null) {
            return null;
        }
        int cmp = item.compareTo(node.item);
        if (cmp == 0) {
            return node.item;
        } else if (cmp < 0) {
            return get(node.left, item);
        } else {
            return get(node.right, item);
        }
    }

    public void put(T item) {
        isKeyNotNull(item);
        if (item == null) {
            delete(item);
            return;
        }
        root = put(root, item);
    }

    private Node put(Node node, T item) {
        if (node == null) {
            return new Node(item);
        }

        int cmp = item.compareTo(node.item);
        if (cmp == 0) {
            node.item = item;
        } else if (cmp < 0) {
            node.left = put(node.left, item);
            if(node.right != null && node.right.depth < node.left.depth){
                node.left.depth++;
            }

        } else {
            node.right = put(node.right, item);
            if(node.left != null && node.left.depth < node.right.depth){
                node.right.depth++;
            }
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.depth = Math.max(depth(node.right), depth(node.left)) + 1;
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public T minItem() {
        return min(root).item;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public T maxItem() {
        return max(root).item;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    public Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(T item) {
        isKeyNotNull(item);
        root = delete(root, item);
    }

    private Node delete(Node node, T item) {
        if (node == null) {
            return null;
        }
        int cmp = item.compareTo(node.item);
        if (cmp < 0) {
            node.left = delete(node.left, item);
        } else if (cmp > 0){
            node.right = delete(node.right, item);
        }else{
            if(node.left == null ){
                return node.right;
            }
            if(node.right == null ){
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.depth = depth(node.left) + depth(node.right) + 1;
        return node;
    }

    @Override
    public String toString() {
        return "BST{" +
                toString(root) +
                '}';
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " + node.item.toString()
                + " " + toString(node.right);
    }
}
