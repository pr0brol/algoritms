package ru.geekbrains.lesson1.lesson7;

import java.util.LinkedList;

public class BreadthFirstSearch extends BaseFirstSearch{

    public BreadthFirstSearch(Graph g, int source) {
        super.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        distTo = new int[g.getVertexCount()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INFINITY;
        }
        bfs(g,source);
    }

    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        distTo[source] = 0;

        while (!queue.isEmpty()){
            int vertex = queue.removeFirst();
            for (int w:g.getAdjList(vertex)) {
                if(!marked[w]){
                    marked[w]= true;
                    edgeTo[w] = vertex;
                    distTo[w] = distTo[vertex] +1;
                    queue.addLast(w);
                }
            }
        }
    }

    public int distTo(int v){
        return distTo[v];
    }

}
