package com.maniavision.impl;

import com.maniavision.adts.IGraph;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class GraphMatrix<T> implements IGraph<T> {
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

    @Override
    public void addVertex(T vertex) {
        if(vertices.size() <= edges.length) {
            vertices.add(vertex);
        }
    }

    @Override
    public void removeVertex(T key) {

    }

    @Override
    public boolean hasVertex(T vertex) {
        return vertices.contains(vertex);
    }

    @Override
    public void addEdge(T from, T to) {
        addRemoveEdge(from, to, 1);
    }

    @Override
    public void addEdge(T from, T to, int weight) {
        addRemoveEdge(from, to, weight);
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

    @Override
    public List<T> getNeighbors(T vertex) {
        List<T> neighbors = new LinkedList<>();
        if(hasVertex(vertex)) {
            int index = vertices.indexOf(vertex);
            for(int v = 0; v < vertices.size(); v++) {
                if(edges[index][v] > 0) {
                    neighbors.add(vertices.get(v));
                }
            }
        }
        return neighbors;
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    @Override
    public void depthFirstSearch() {
        boolean visited[] = new boolean[vertices.size()];

        for(int i = 0; i < edges.length; i++) {
            for(int j = 0; j < edges[0].length; j++){
                if(edges[i][j] > 0 && !visited[i]) {
                    dfsUtil(i, visited);
                }
            }
        }
    }

    @Override
    public void depthFirstSearch(T sourceVertex) {
        if(hasVertex(sourceVertex)) {
            boolean visited[] = new boolean[vertices.size()];
            int sourceIndex = vertices.indexOf(sourceVertex);
            dfsUtil(sourceIndex, visited);
        }
    }

    @Override
    public boolean depthFirstSearch(T sourceVertex, T targetVertex) {
        if(hasVertex(sourceVertex) && hasVertex(targetVertex)) {
            boolean visited[] = new boolean[vertices.size()];
            int sourceIndex = vertices.indexOf(sourceVertex);
            int targetIndex = vertices.indexOf(targetVertex);
            dfsUtil(sourceIndex, visited);
            return visited[targetIndex];
        }
        return false;
    }

    private void dfsUtil(int u, boolean visited[]) {
        visited[u] = true;
        for(int v = 0; v < edges[0].length; v++){
            if(edges[u][v] > 0 && !visited[v]) {
                System.out.println("(" + vertices.get(u) + ", " + vertices.get(v) + ")");
                dfsUtil(v, visited);
            }
        }
    }

    @Override
    public void breathFirstSearch() {
        boolean visited[] = new boolean[vertices.size()];
        for(int i = 0; i < vertices.size(); i++) {
            for(int j = 0; j < vertices.size(); j++) {
                if(edges[i][j] > 0 && !visited[i]){
                    bfsUtil(i, visited);
                }
            }
        }
    }

    @Override
    public void breathFirstSearch(T sourceVertex) {
        if(hasVertex(sourceVertex)) {
            boolean visited[] = new boolean[vertices.size()];
            int sourceIndex = vertices.indexOf(sourceVertex);
            bfsUtil(sourceIndex, visited);
        }
    }

    @Override
    public boolean breathFirstSearch(T sourceVertex, T targetVertex) {
        if(hasVertex(sourceVertex) && hasVertex(targetVertex)) {
            boolean visited[] = new boolean[vertices.size()];
            int sourceIndex = vertices.indexOf(sourceVertex);
            int targetIndex = vertices.indexOf(targetVertex);
            bfsUtil(sourceIndex, visited);
            return visited[targetIndex];
        }
        return false;
    }

    private void bfsUtil(int u, boolean visited[]) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(u);
        visited[u] = true;
        while(!queue.isEmpty()) {
            u = queue.poll();
            for(int v = 0; v < vertices.size(); v++) {
                if(edges[u][v] > 0 && !visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                    System.out.println("(" + vertices.get(u) + ", " + vertices.get(v) + ")");
                }
            }
        }
    }

    @Override
    public int componentsCount() {
        int count = 0;
        boolean visited[] = new boolean[vertices.size()];
        for(int index = 0; index < vertices.size(); index++) {
            if(!visited[index]) {
                count++;
                dfsUtil(index, visited);
            }
        }
        return count;
    }

    @Override
    public void topologicalSort() {
        Stack<T> stk = new Stack<>();

        for(T vertex: vertices) {
            if(inDegreeCount(vertex) == 0) {
                stk.push(vertex);
            }
        }

        int i = 1;
        while(!stk.isEmpty()) {
            T u = stk.pop();
            System.out.println(u);
            for(T neighbor: getNeighbors(u)) {
                int inD = inDegreeCount(neighbor) -1;
                if(inD == 0) {
                    stk.push(neighbor);
                }
            }

        }
    }

    @Override
    public boolean hasCycle() {
        return false;
    }

    @Override
    public void shortestPath(T fromVertex, T toVertex) {

    }

    @Override
    public int degreeCount(T vertex) {
        int count = 0;

        if(vertices.contains(vertex)) {
            int index = vertices.indexOf(vertex);
            for(int v = 0; v < vertices.size(); v++) {
                if(edges[index][v] > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int inDegreeCount(T vertex) {
        int count = 0;
        if(hasVertex(vertex)) {
            int index = vertices.indexOf(vertex);
            for(int u = 0; u < vertices.size(); u++) {
                if(edges[u][index] > 0) {
                    count++;
                }
            }

        }
        return count;
    }

    @Override
    public int outDegreeCount(T vertex) {
        return degreeCount(vertex);
    }


    public void primMST() {
        int parent[] = new int[vertices.size()];
        int key[] = new int[vertices.size()];
        boolean mstSet[] = new boolean[vertices.size()];

        for(int i = 0; i < vertices.size(); i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

//        int sourceIndex = vertices.indexOf(source);
        key[0] = 0;
        parent[0] = -1;

        for(int count = 0; count < vertices.size(); count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for(int v = 0; v < vertices.size(); v++) {
                if(edges[u][v] != 0 && mstSet[v] == false && edges[u][v] < key[v]){
                    parent[v] = u;
                    key[v] = edges[u][v];
                }
            }
        }
        printMST(parent);
    }

    private int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int v = 0; v < vertices.size(); v++) {
            if(mstSet[v] == false && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printMST(int parent[]) {
        System.out.println("Edge \tWeight");
        for(int i = 1; i < vertices.size(); i++){
            System.out.println(parent[i] + " - " + i + "\t" + edges[parent[i]][i]);
        }
    }

    public void print() {
        for(int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + " -> ");
            for(int j = 0; j < vertices.size(); j++) {
                if(edges[i][j] > 0) {
                    System.out.print(vertices.get(j) + " | ");
                }
            }
            System.out.println();
        }
    }

}
