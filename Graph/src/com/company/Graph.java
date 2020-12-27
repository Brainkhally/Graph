package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Graph {
    //Реализовать классы графа
    private final int MAX_SIZE = 10;
    private Vertex vertices[] = new Vertex[MAX_SIZE];
    //Связи представить в виде матрицы смежности.
    int adjMatrix[][] = new int[MAX_SIZE][MAX_SIZE];
    private int size;

    public boolean addVertex(char label) {
        //Предусмотреть возможость добавления новых вершин
        if (size < MAX_SIZE) {
            vertices[size++] = new Vertex(label);
            return true;
        }
        return false;
    }

    public boolean addEdge(int start, int finish) {
        //Предусмотреть возможость добавления новых ребер
        if (start < size && finish < size && start > -1 && finish > -1) {
            adjMatrix[start][finish] = adjMatrix[finish][start] = 1;
            return true;
        }
        return false;
    }

    public void searchDepth(int current) {
        //Предусмотреть возможость обход графа в глубину
        System.out.println("I-" + current + ", V-" + vertices[current].getLabel());
        vertices[current].setVisited(true);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int num;
        while ((num = getAbjVertex(current)) != -1) {
            deque.add(num);
        }
        while (!deque.isEmpty()) {
            searchDepth(deque.poll());
        }
    }

    public int getAbjVertex(int start) {
        if (start > -1 && start < size) {
            for (int i = 0; i < size; i++) {
                if (adjMatrix[start][i] == 1 && !vertices[i].isVisited()) {
                    vertices[i].setVisited(true);
                    return i;
                }
            }
        }
        return -1;
    }
}
