package com.maniavision.impl;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class GraphList<T> {

    private List<T> vertices;
    private List<List<Integer>> edges;
    private boolean isDirected;
    private boolean visited[];
    private int parents[];
    private boolean articulationPoints[];
    private  int discoveryTime[];
    private int minimumTime[];
    private int time;
    public GraphList(boolean isDirected) {
        this.vertices = new java.util.LinkedList<>();
        this.edges = new java.util.LinkedList<>();
        this.isDirected = isDirected;
    }

    public void addVertex(T value) {
        if(!vertices.contains(value)) {
            vertices.add(value);
            edges.add(new LinkedList<>());
        }
    }

    public void addEdge(T source, T dest) {
        if(vertices.contains(source) && vertices.contains(dest)) {
            int srcIndex = vertices.indexOf(source);
            int dstIndex = vertices.indexOf(dest);
            edges.get(srcIndex).add(dstIndex);
            if(!isDirected) {
                edges.get(dstIndex).add(srcIndex);
            }
        }
    }

    public void removeVertex(T value) {
        int index = vertices.indexOf(value);
        edges.remove(index);
        vertices.remove(value);

        for(List<Integer> neighbors : edges) {
            if(neighbors.contains(index)) {
                neighbors.remove(index);
            }
        }
    }

    public void removeEdge(T source, T dest) {
        if(vertices.contains(source) && vertices.contains(dest)) {
            int srcIndex = vertices.indexOf(source);
            int destIndex = vertices.indexOf(dest);
            edges.get(srcIndex).remove(destIndex);
            if(!isDirected) {
                edges.get(destIndex).remove(srcIndex);
            }
        }
    }

    private void initArrays() {
        if(visited == null || parents == null) {
            visited = new boolean[vertices.size()];
            parents = new int[vertices.size()];
            articulationPoints = new boolean[vertices.size()];
            discoveryTime = new int[vertices.size()];
            minimumTime = new int[vertices.size()];
        }
    }

    private void resetArrays() {
        for(int i = 0; i < visited.length; i++) {
            visited[i] = false;
            parents[i] = 0;
            articulationPoints[i] = false;
            discoveryTime[i] = 0;
            minimumTime[i] = 0;
        }
    }

    public void dfs() {
        initArrays();
        resetArrays();
        time = 0;
        for(int index = 0; index < vertices.size(); index++) {
            if(!visited[index]) {
                dfs(index, -1);
            }
        }
//        resetArrays();
    }

    private void dfs(int vertexIndex, int parentIndex) {
        visited[vertexIndex] = true;
        int childrenCount = 0;
        discoveryTime[vertexIndex] = minimumTime[vertexIndex] = ++time;
        List<Integer> neighbors = edges.get(vertexIndex);
        for(Integer neighborIndex: neighbors) {
            if(!visited[neighborIndex]) {
                System.out.println(vertices.get(vertexIndex) + " -> " + vertices.get(neighborIndex));
                childrenCount++;
                dfs(neighborIndex, vertexIndex);
                minimumTime[vertexIndex] = Math.min(minimumTime[vertexIndex], minimumTime[neighborIndex]);

                if(parentIndex != -1 && minimumTime[neighborIndex] >= discoveryTime[vertexIndex]) {
                    articulationPoints[vertexIndex] = true;
                }
            } else if(neighborIndex != parentIndex) {
                minimumTime[vertexIndex] = Math.min(minimumTime[vertexIndex], minimumTime[neighborIndex]);
            }
        }

        // If vertex is root of the dfs tree and has more than one child
        if(parentIndex == -1 && childrenCount > 1)
            articulationPoints[vertexIndex] = true;
    }

    public void bfs() {
        initArrays();
        for(int index = 0; index < vertices.size(); index++) {
            if(!visited[index]) {
                bfs(index);
            }
        }
    }

    private void bfs(int vertexIndex) {
        resetArrays();
        visited[vertexIndex] = true;
        parents[vertexIndex] = -1;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(vertexIndex);
        while(!queue.isEmpty()) {
            vertexIndex = queue.poll();
            List<Integer> neighbors = edges.get(vertexIndex);
            for(Integer neighborsIndex: neighbors) {
                if(!visited[neighborsIndex]) {
                    System.out.println(vertices.get(vertexIndex) + " -> " + vertices.get(neighborsIndex));
                    visited[neighborsIndex] = true;
                    parents[neighborsIndex] = vertexIndex;
                    queue.add(neighborsIndex);
                }
            }
        }
    }

    public int componentsCount() {
        int counter = 0;
        for(int index = 0; index < vertices.size(); index++) {
            if(!visited[index]) {
                counter++;
                dfs(index, -1);
            }
        }
        return counter;
    }

    public void shortestPath(T source, T dest) {
        int srcIndex = vertices.indexOf(source);
        int dstIndex = vertices.indexOf(dest);
        bfs(srcIndex);
        shortestPath(srcIndex, dstIndex);
    }

    private void shortestPath(int srcIndex, int dstIndex) {
        if(srcIndex == dstIndex || dstIndex == -1) {
            System.out.print(vertices.get(srcIndex) + " -> ");
        } else {
            shortestPath(srcIndex, parents[dstIndex]);
            System.out.print(vertices.get(dstIndex) + " -> ");
        }
    }

    public void findArticulationPoints() {
        dfs();
        for(int index = 0; index < articulationPoints.length; index++) {
            if(articulationPoints[index]) {
                System.out.println(vertices.get(index) + " is an articulation point");
            }
        }
    }

    public void print() {
        for(int index = 0; index < edges.size(); index++) {
            System.out.print(vertices.get(index) + " -> ");
            for(Integer neighborIndex: edges.get(index)) {
                System.out.print(vertices.get(neighborIndex) + " | ");
            }
            System.out.println();
        }
    }
}
