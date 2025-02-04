package com.maniavision.impl;

import com.maniavision.adts.IGraph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyListGraph implements IGraph {

    private List<Integer> vertices;
    private List<List<Integer>> edges;
    private boolean isDirected;

    public AdjacencyListGraph(boolean isDirected) {
        this.isDirected = isDirected;
        this.vertices = new LinkedList<>();
        this.edges = new LinkedList<>();
    }
    @Override
    public void addVertex(int vertex) {
        if(!vertices.contains(vertex)) {
            vertices.add(vertex);
            edges.add(new LinkedList<>());
        }
    }

    @Override
    public boolean hasVertex(int vertex) {
        return vertices.contains(vertex);
    }

    @Override
    public void addEdge(int fromVertex, int toVertex, int cost) {
        if(vertices.contains(fromVertex) && vertices.contains(toVertex)) {
            int fromIndex = vertices.indexOf(fromVertex);
            int toIndex = vertices.indexOf(toVertex);
            edges.get(fromIndex).add(toVertex);

            if(!isDirected)
                edges.get(toIndex).add(fromVertex);
        }
    }

    @Override
    public List<Integer> getVertices(int vertex) {
        if(vertices.contains(vertex)) {
            vertices.add(vertex);
            return edges.get(vertices.indexOf(vertex));
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    @Override
    public void depthFirstSearch(int source) {
        boolean visited[] = new boolean[vertices.size()];
        dfsUtilV1(source, visited);
    }

    @Override
    public boolean depthFirstSearch(int source, int target) {
        boolean visited[] = new boolean[vertices.size()];
        return dfsUtilV2(source, target, visited);
    }

    private boolean dfsUtilV2(int v, int target, boolean visited[]) {
        visited[v] = true;
        int index = vertices.indexOf(v);
        for(Integer adjacentVertex: edges.get(index)) {
            if(adjacentVertex == target)
                return true;
            else if(!visited[adjacentVertex])
                return dfsUtilV2(adjacentVertex, target, visited);
        }
        return false;
    }

    private void dfsUtilV1(int v, boolean visited[]) {
        visited[v] = true;
        int index = vertices.indexOf(v);
        for(Integer adjacentVertex: edges.get(index)) {
            if(!visited[adjacentVertex]) {
                System.out.println("(" + v + ", " + adjacentVertex + ")");
                dfsUtilV1(adjacentVertex, visited);
            }
        }
    }

    @Override
    public void breathFirstSearch(int source) {
        boolean visited[] = new boolean[vertices.size()];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[source] = true;
        q.add(source);
        while(!q.isEmpty()) {
            source = q.poll();

            for(Integer adjacencyVertex: edges.get(vertices.indexOf(source))) {
                if(!visited[adjacencyVertex]) {
                    System.out.println("(" + source + ", " + adjacencyVertex + ")");
                    visited[adjacencyVertex] = true;
                    q.add(adjacencyVertex);
                }
            }
        }
    }

    @Override
    public boolean breathFirstSearch(int source, int target) {
        boolean visited[] = new boolean[vertices.size()];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[source] = true;
        q.add(source);
        while(!q.isEmpty()) {
            source = q.poll();

            for(Integer adjacencyVertex: edges.get(vertices.indexOf(source))) {
                if(adjacencyVertex == target)
                    return true;
                if(!visited[adjacencyVertex]) {
                    visited[adjacencyVertex] = true;
                    q.add(adjacencyVertex);
                }
            }
        }
        return false;
    }
}
