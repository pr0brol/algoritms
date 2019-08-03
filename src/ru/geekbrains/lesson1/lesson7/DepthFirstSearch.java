package ru.geekbrains.lesson1.lesson7;

public class DepthFirstSearch extends BaseFirstSearch{

    public DepthFirstSearch(Graph g, int source) {
        super.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        dfs(g,source);
    }

    private void dfs(Graph g, int v){
        marked[v] = true;
        for (int w :g.getAdjList(v)) {
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(g,w);
            }
        }
    }


}
