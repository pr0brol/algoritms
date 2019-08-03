package ru.geekbrains.lesson1.lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(16);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(4, 10);
        graph.addEdge(5, 8);
        graph.addEdge(6, 7);
        graph.addEdge(2, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 11);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 13);
        graph.addEdge(11, 13);
        graph.addEdge(11, 12);
        graph.addEdge(12, 14);
        graph.addEdge(13, 15);
        graph.addEdge(14, 15);
        graph.addEdge(1, 5);

//        System.out.println(graph.getAdjList(1));

//        DepthFirstSearch dfs = new DepthFirstSearch(graph,2);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 1);

        System.out.println(bfs.hasPathTo(2));
        System.out.println(bfs.pathTo(9));
        System.out.println(bfs.hasPathTo(7));

    }
}
