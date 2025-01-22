package com.maniavision.impl;

import com.maniavision.adts.IGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AdjacencyMatrixDirectedGraph implements IGraph {
    private static int DEFAULT_CAPACITY = 10;
    private int numbVertices;
    private int maxVertices;
    private int vertices[];
    private int edges[][];

    public AdjacencyMatrixDirectedGraph() {
        numbVertices = 0;
        vertices = new int[DEFAULT_CAPACITY];
        edges = new int[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    public AdjacencyMatrixDirectedGraph(int numbVertices) {
        numbVertices = 0;
        maxVertices = numbVertices;
        vertices = new int[maxVertices];
        edges = new int[maxVertices][maxVertices];
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

    @Override
    public void addEdge(int fromVertex, int toVertex, int cost) {
        edges[fromVertex][toVertex] = cost;
    }

    @Override
    public List<Integer> getVertices(int vertex) {
        return null;
    }

//    @Override
//    public List<Integer> getVertices(int vertex) {
//        List<Integer> output = new LinkedList<>();
//
//        for(int r = 0; r < numbVertices; r++) {
//            for(int c = 0; c < numbVertices; c++) {
//                if()
//            }
//        }
//        return null;
//    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean depthFirstSearch(int source, int target) {
        boolean visited[] = new boolean[numbVertices];
        dfsUtil(source, visited);
        return visited[target];
    }

    private void dfsUtil(int index, boolean[] visited) {
        visited[index] = true;
        for(int i = 0; i < edges[index].length; i++) {
            if(edges[index][i] == 1 && !visited[i]) {
                dfsUtil(i, visited);
                System.out.println("(" + index + "," + i + ")");
            }
        }
    }

    public boolean depthFirstSearchV1(int source, int target) {
        boolean visited[] = new boolean[numbVertices];
        Stack<Integer> stk = new Stack<>();
        stk.push(source);

        while(!stk.empty()) {
            int v = stk.pop();
            visited[v] = true;
            for(int i = 0; i < edges[v].length; i++) {
                if(edges[v][i] == 1 && !visited[i]){
                    System.out.println("(" + v + "," + i +")");
                    stk.push(i);
                }
            }
        }
        return visited[target];
    }


    @Override
    public boolean breathFirstSearch(int source, int target) {
        return false;
    }
}
