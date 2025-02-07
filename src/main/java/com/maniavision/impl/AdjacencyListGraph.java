package com.maniavision.impl;

import com.maniavision.adts.IGraph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AdjacencyListGraph implements IGraph {

    private List<Integer> vertices;
    private List<List<Integer>> edges;
    private boolean isDirected;
    private boolean hasCycle;
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
        int index = vertices.indexOf(source);
        dfsUtil(index, visited, null);
    }

    private void dfsUtil(int index, boolean visited[], Stack<Integer> stack) {
        visited[index] = true;
        for(Integer adjacentVertex: edges.get(index)) {
            int adjIndex = vertices.indexOf(adjacentVertex);
            if(!visited[adjIndex]) {
                System.out.println("(" + vertices.get(index) + ", " + adjacentVertex + ")");
                dfsUtil(adjacentVertex, visited, stack);
            }
        }
        stack.push(vertices.get(index));
    }

    @Override
    public boolean depthFirstSearch(int source, int target) {
        boolean visited[] = new boolean[vertices.size()];
        int srcIndex = vertices.indexOf(source);
        int trgIndex = vertices.indexOf(target);
        dfsUtil(srcIndex, visited, null);
        return visited[trgIndex];
    }

    @Override
    public void breathFirstSearch(int source) {
        boolean visited[] = new boolean[vertices.size()];
        breathFirstSearch(source, visited);
    }

    private void breathFirstSearch(int source, boolean visited[]) {
        visited = new boolean[vertices.size()];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int index = vertices.indexOf(source);
        visited[index] = true;
        q.add(index);
        while(!q.isEmpty()) {
            index = q.poll();
            for(Integer adjacentVertex: edges.get(index)) {
                int adjIndex = vertices.indexOf(adjacentVertex);
                if(!visited[adjIndex]) {
                    System.out.println("(" + vertices.get(index) + ", " + adjacentVertex + ")");
                    visited[adjIndex] = true;
                    q.add(adjIndex);
                }
            }
        }
    }

    @Override
    public boolean breathFirstSearch(int source, int target) {
        boolean visited[] = new boolean[vertices.size()];
        breathFirstSearch(source, visited);
        int trgIndex = vertices.indexOf(target);
        return visited[trgIndex];
    }

    @Override
    public int connectedComponents() {
        int count = 0;
        boolean visited[] = new boolean[vertices.size()];
        for(int i = 0; i < vertices.size(); i++) {
            if(!visited[i]) {
                dfsUtil(i, visited, null);
                count++;
            }
        }
        return count;
    }

    @Override
    public void topologicalSort() {
        if(isDirected /*&& !hasCycle*/) {
            boolean visited[] = new boolean[vertices.size()];
            Stack<Integer> stk = new Stack<>();
            for(int i = 0; i < vertices.size(); i++) {
                if(!visited[i])
                    dfsUtil(i, visited, stk);
            }

            while(!stk.isEmpty()) {
                int vertex = stk.pop();
                String arrow = (stk.isEmpty()) ? "" : " -> ";
                System.out.print(vertex + arrow);
            }
            System.out.println();
        }
    }
}
