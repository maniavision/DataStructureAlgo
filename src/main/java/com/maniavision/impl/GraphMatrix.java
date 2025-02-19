package com.maniavision.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class GraphMatrix<T> {
    private List<T> vertices;
    private int edges[][];
    private boolean isDirected;

    public GraphMatrix(int inputSize, boolean inputIsDirected) {
        vertices = new ArrayList<>(inputSize);
        edges = new int[inputSize][inputSize];
        isDirected = inputIsDirected;

        for(int i = 0; i < inputSize; i++) {
            for(int j = 0; j < inputSize; j++) {
                edges[i][j] = 0;
            }
        }
    }

    public void addVertex(T vertex) {
        if(vertices.size() <= edges.length) {
            vertices.add(vertex);
        }
    }

    public void addEdge(T from, T to) {
        addRemoveEdge(from, to, 1);
    }

    public void removeEdge(T from, T to) {
        addRemoveEdge(from, to, 0);
    }

    private void addRemoveEdge(T from, T to, int value) {
        if(vertices.contains(from) && vertices.contains(to)) {
            int fromIndex = vertices.indexOf(from);
            int toIndex = vertices.indexOf(to);
            edges[fromIndex][toIndex] = value;
            if(!isDirected){
                edges[toIndex][fromIndex] = value;
            }
        }
    }

    public void dfs() {
        boolean visited[] = new boolean[vertices.size()];

        for(int i = 0; i < edges.length; i++) {
            for(int j = 0; j < edges[0].length; j++){
                if(edges[i][j] == 1 && !visited[i]) {
                    dfsUtil(i, visited);
                }
            }
        }
    }

    private void dfsUtil(int u, boolean visited[]) {
        visited[u] = true;

        for(int v = 0; v < edges[0].length; v++){
            if(edges[u][v] == 1 && !visited[v]) {
                System.out.println("(" + vertices.get(u) + ", " + vertices.get(v) + ")");
                dfsUtil(v, visited);
            }
        }
    }

    public void bfs() {
        boolean visited[] = new boolean[vertices.size()];

        for(int i = 0; i < vertices.size(); i++) {
            for(int j = 0; j < vertices.size(); j++) {
                if(edges[i][j] == 1 && !visited[i]){
                    bfs(i, visited);
                }
            }
        }
    }

    private void bfs(int u, boolean visited[]) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(u);
        visited[u] = true;

        while(!queue.isEmpty()) {
            u = queue.poll();

            for(int v = 0; v < vertices.size(); v++) {
                if(edges[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                    System.out.println("(" + vertices.get(u) + ", " + vertices.get(v) + ")");
                }
            }
        }
    }

    public void print() {
        for(int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + " -> ");
            for(int j = 0; j < vertices.size(); j++) {
                if(edges[i][j] == 1) {
                    System.out.print(vertices.get(j) + " | ");
                }
            }
            System.out.println();
        }
    }

}
