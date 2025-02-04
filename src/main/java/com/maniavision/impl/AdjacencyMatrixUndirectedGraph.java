package com.maniavision.impl;

import com.maniavision.adts.IGraph;

import java.util.List;

public class AdjacencyMatrixUndirectedGraph implements IGraph {

    private static int DEFAULT_CAPACITY = 5;
    private int numberOfVertices;
    private int vertices[];
    private int edges[][];

    public AdjacencyMatrixUndirectedGraph() {
        numberOfVertices = 0;
        vertices = new int[DEFAULT_CAPACITY];
        edges = new int[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    public AdjacencyMatrixUndirectedGraph(int initCapacity) {
        numberOfVertices = 0;
        vertices = new int[initCapacity];
        edges = new int[initCapacity][initCapacity];
    }

    @Override
    public void addVertex(int vertex) {
        vertices[numberOfVertices] = vertex;

        for(int i = 0; i < numberOfVertices; i++) {
            edges[vertex][i] = 0;
        }
        numberOfVertices++;
    }

    @Override
    public boolean hasVertex(int vertex) {
        return false;
    }

    @Override
    public void addEdge(int fromVertex, int toVertex, int cost) {
        edges[fromVertex][toVertex] = cost;
        edges[toVertex][fromVertex] = cost;
    }

    @Override
    public List<Integer> getVertices(int vertex) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean depthFirstSearch(int source, int target) {
        boolean visited[] = new boolean[numberOfVertices];
        dfsUtil(source, visited);
        return visited[target];
    }

    private void dfsUtil(int index, boolean visited[]) {
        visited[index] = true;
        for(int i = 0; i < edges[index].length; i++) {
            if(edges[index][i] == 1 && !visited[i]) {
                System.out.println("(" + index + "," + i + ")");
                dfsUtil(i, visited);
            }
        }
    }

    @Override
    public boolean breathFirstSearch(int source, int target) {
        return false;
    }
}
