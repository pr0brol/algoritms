package ru.geekbrains.lesson1.lesson7;

import java.util.LinkedList;

public class BaseFirstSearch {

    protected boolean[] marked;
    protected int[] edgeTo;
    protected int source;
    protected int[] distTo;
    protected final int INFINITY = Integer.MAX_VALUE;

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;
        while (vertex !=source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
