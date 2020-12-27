package com.company;


public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        for (int i = 0; i < 7; i++) {
            graph.addVertex((char)('1' + i));
        }
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        graph.searchDepth(0);
    }
}
