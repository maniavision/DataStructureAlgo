package com.maniavision.impl;

import com.maniavision.adts.IGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdjacencyMatrixGraph implements IGraph {
    private static int DEFAULT_CAPACITY = 10;
    private int numbVertices;
    private int maxVertices;
    private int vertices[];
    private int edges[][];
    private boolean isDirected;

    public AdjacencyMatrixGraph(boolean isDirected) {
        this.isDirected = isDirected;
        this.numbVertices = 0;
        this.vertices = new int[DEFAULT_CAPACITY];
        this.edges = new int[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    public AdjacencyMatrixGraph(boolean isDirected, int capacity) {
        this.isDirected = isDirected;
        this.numbVertices = 0;
        this.maxVertices = capacity;
        this.vertices = new int[maxVertices];
        this.edges = new int[maxVertices][maxVertices];
    }

    @Override
    public void addVertex(int vertex) {
        vertices[numbVertices] = vertex;

        for(int index = 0; index < numbVertices; ++index) {
            edges[numbVertices][index] = 0;
            edges[index][numbVertices] = 0;
        }
        numbVertices++;
    }

    @Override
    public boolean hasVertex(int vertex) {
        boolean found = false;
        int index = 0;
        while(index < vertices.length && !found) {
            if(vertex == vertices[index])
                found = true;
            else
                index++;
        }
        return found;
    }

    private int indexOf(int vertex) {
        int index = 0;
        while(index < vertices.length) {
            if(vertices[index] == vertex)
                return index;
            else
                index++;
        }
        return -1;
    }

    @Override
    public void addEdge(int fromVertex, int toVertex, int cost) {
        int row = indexOf(fromVertex);
        int col = indexOf(toVertex);
        edges[row][col] = cost;
        if(!isDirected)
            edges[col][row] = cost;
    }

    @Override
    public List<Integer> getVertices(int vertex) {
        List<Integer> adjacentIndexes = new ArrayList<>();
        int index = indexOf(vertex);
        for(int r = 0; r < edges.length; r++) {
            for(int c = 0; c < edges[0].length; c++) {
                if(r == index && edges[r][c] != 0) {
                    adjacentIndexes.add(c);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(Integer idx: adjacentIndexes) {
            result.add(vertices[idx]);
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return vertices.length == 0;
    }

    @Override
    public void depthFirstSearch(int source) {
        boolean visited[] = new boolean[numbVertices];
        int index = indexOf(source);
        dfsUtil(index, visited);
    }

    @Override
    public boolean depthFirstSearch(int source, int target) {
        boolean visited[] = new boolean[numbVertices];
        int index = indexOf(source);
        dfsUtil(index, visited);
        return visited[target];
    }

    @Override
    public void breathFirstSearch(int source) {
        boolean visited[] = new boolean[numbVertices];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int index = indexOf(source);
        visited[index] = true;
        queue.add(index);
        while(!queue.isEmpty()) {
            index = queue.poll();
            for(int i = 0; i < edges[index].length; i++) {
                if(edges[index][i] == 1 && !visited[i]){
                    visited[i] = true;
                    System.out.println("(" + vertices[index] + "," + vertices[i] +")");
                    queue.add(i);
                }
            }
        }
    }

    private void dfsUtil(int index, boolean[] visited) {
        visited[index] = true;
        for(int i = 0; i < edges[index].length; i++) {
            if(edges[index][i] == 1 && !visited[i]) {
                System.out.println("(" + vertices[index] + "," + vertices[i] + ")");
                dfsUtil(i, visited);
            }
        }
    }

    public boolean depthFirstSearchV1(int source, int target) {
        boolean visited[] = new boolean[numbVertices];
        Stack<Integer> stk = new Stack<>();
        int index = indexOf(source);
        visited[index] = true;
        stk.push(index);

        while(!stk.empty()) {
            index = stk.pop();
            for(int i = 0; i < edges[index].length; i++) {
                if(edges[index][i] == 1 && !visited[i]){
                    System.out.println("(" + vertices[index] + "," + vertices[i] +")");
                    visited[i] = true;
                    stk.push(i);
                }
            }
        }
        return visited[indexOf(target)];
    }


    @Override
    public boolean breathFirstSearch(int source, int target) {
        boolean visited[] = new boolean[numbVertices];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int index = indexOf(source);
        visited[index] = true;
        queue.add(index);
        while(!queue.isEmpty()) {
            index = queue.pop();
            for(int i = 0; i < edges[index].length; i++) {
                if(edges[index][i] == 1 && !visited[i]){
                    System.out.println("(" + vertices[index] + "," + vertices[i] +")");
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return visited[indexOf(target)];
    }

    @Override
    public int connectedComponents() {
        int count = 0;
        boolean visited[] = new boolean[vertices.length];
        for(Integer v: vertices) {
            int index = indexOf(v);
            if(!visited[index]) {
                dfsUtil(index, visited);
                count++;
            }
        }
        return count;
    }
}
