package com.maniavision.impl;

import com.maniavision.adts.IGraph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AdjacencyListGraph  {

    private List<Vertex> vertices;
    private List<List<Vertex>> edges;
    private boolean isDirected;
    private boolean hasCycle;
    private int parents[];
    public AdjacencyListGraph(boolean isDirected) {
        this.isDirected = isDirected;
        this.vertices = new LinkedList<>();
        this.edges = new LinkedList<>();
    }
    public void addVertex(Vertex vertex) {
        if(!vertices.contains(vertex)) {
            vertices.add(vertex);
            edges.add(new LinkedList<>());
        }
    }

    public boolean hasVertex(Vertex vertex) {
        return vertices.contains(vertex);
    }

    public void addEdge(Vertex fromVertex, Vertex toVertex, int cost) {
        if(vertices.contains(fromVertex) && vertices.contains(toVertex)) {
            int fromIndex = vertices.indexOf(fromVertex);
            int toIndex = vertices.indexOf(toVertex);
            edges.get(fromIndex).add(toVertex);

            if(!isDirected)
                edges.get(toIndex).add(fromVertex);
        }
    }

    public List<Vertex> getVertices(Vertex vertex) {
        if(vertices.contains(vertex)) {
            vertices.add(vertex);
            return edges.get(vertices.indexOf(vertex));
        }
        return null;
    }

    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    public void depthFirstSearch(Vertex source) {
        dfsUtil(source, null);
    }

    private void dfsUtil(Vertex vertex, Stack<Vertex> stack) {
        int vertexIndex = vertices.indexOf(vertex);
        vertex.status = VertexStatus.VISITED;
        for(Vertex adjacentVertex: edges.get(vertexIndex)) {
            if(adjacentVertex.status == VertexStatus.UNVISITED) {
                System.out.println("(" + vertex.value + ", " + adjacentVertex.value + ")");
                dfsUtil(adjacentVertex, stack);
            }
        }
        if(stack != null)
            stack.push(vertex);
    }

//    @Override
//    public boolean depthFirstSearch(int source, int target) {
//        boolean visited[] = new boolean[vertices.size()];
//        int srcIndex = vertices.indexOf(source);
//        int trgIndex = vertices.indexOf(target);
//        dfsUtil(srcIndex, visited, null);
//        return visited[trgIndex];
//    }
//
//    @Override
//    public void breathFirstSearch(int source) {
//        boolean visited[] = new boolean[vertices.size()];
//        parents = new int[vertices.size()];
//        breathFirstSearch(source, visited);
//    }
//
//    private void breathFirstSearch(int source, boolean visited[]) {
//        visited = new boolean[vertices.size()];
//        parents = new int[vertices.size()];
//        ArrayDeque<Integer> q = new ArrayDeque<>();
//        int index = vertices.indexOf(source);
//        visited[index] = true;
//        parents[index] = -1;
//        q.add(index);
//        while(!q.isEmpty()) {
//            index = q.poll();
//            for(Integer adjacentVertex: edges.get(index)) {
//                int adjIndex = vertices.indexOf(adjacentVertex);
//                if(!visited[adjIndex]) {
//                    System.out.println("(" + vertices.get(index) + ", " + adjacentVertex + ")");
//                    visited[adjIndex] = true;
//                    parents[adjIndex] = index;
//                    q.add(adjIndex);
//                }
//            }
//        }
//    }
//
//    @Override
//    public boolean breathFirstSearch(int source, int target) {
//        boolean visited[] = new boolean[vertices.size()];
//        breathFirstSearch(source, visited);
//        int trgIndex = vertices.indexOf(target);
//        return visited[trgIndex];
//    }
//
//    @Override
//    public int connectedComponents() {
//        int count = 0;
//        boolean visited[] = new boolean[vertices.size()];
//        for(int i = 0; i < vertices.size(); i++) {
//            if(!visited[i]) {
//                dfsUtil(i, visited, null);
//                count++;
//            }
//        }
//        return count;
//    }
//
//    @Override
//    public void topologicalSort() {
//        if(isDirected /*&& !hasCycle*/) {
//            boolean visited[] = new boolean[vertices.size()];
//            Stack<Integer> stk = new Stack<>();
//            for(int i = 0; i < vertices.size(); i++) {
//                if(!visited[i])
//                    dfsUtil(i, visited, stk);
//            }
//
//            while(!stk.isEmpty()) {
//                int vertex = stk.pop();
//                String arrow = (stk.isEmpty()) ? "" : " -> ";
//                System.out.print(vertex + arrow);
//            }
//            System.out.println();
//        }
//    }
//
//    @Override
//    public boolean hasCycle() {
//        if(isDirected)
//            return hasCycleDirected();
//        else
//            return hasCycleUndirected();
//    }
//
//    @Override
//    public void shortestPath(int start, int end) {
//        breathFirstSearch(start, end);
//        int startIndex = vertices.indexOf(start);
//        int endIndex = vertices.indexOf(end);
//        shortestPath(startIndex, endIndex, parents);
//    }
//
//    private void shortestPath(int start, int end, int parents[]) {
//        if(start == end || end == -1) {
//            System.out.print(vertices.get(start) + " ");
//        } else {
//            shortestPath(start, this.parents[end], parents);
//            System.out.print(vertices.get(end) + " ");
//        }
//    }
//
//    public void shortestPathV2(int start, int end) {
//        breathFirstSearch(start);
//        Stack<Integer> stk = new Stack<>();
//        int index = vertices.indexOf(end);
//        while(index != -1) {
//            stk.push(index);
//            index = this.parents[index];
//        }
//
//        while(!stk.isEmpty())
//            System.out.print(vertices.get(stk.pop()) + " ");
//    }
//
//    private boolean hasCycleUndirected() {
//        boolean visited[] = new boolean[vertices.size()];
//
//        for(int i = 0; i < vertices.size(); i++) {
//            if(!visited[i] && dfsHasCycle(i, -1, visited))
//                return true;
//        }
//        return false;
//    }
//
//    private boolean hasCycleDirected() {
//        boolean visited[] = new boolean[vertices.size()];
//        boolean recStack[] = new boolean[vertices.size()];
//
//        for(int index = 0; index < vertices.size(); index++) {
//            if(!visited[index] && dfsHasCycle(index, visited, recStack))
//                return true;
//        }
//        return false;
//    }
//
//    private boolean dfsHasCycle(int index, boolean visited[], boolean recStack[]) {
//        visited[index] = true;
//        recStack[index] = true;
//        List<Integer> neighbors = edges.get(index);
//
//        for(Integer neighbor: neighbors) {
//            int neighborIndex = vertices.indexOf(neighbor);
//            if(!visited[neighborIndex]) {
//                if(dfsHasCycle(neighborIndex, visited, recStack)) {
//                    return true;
//                }
//            } else if(recStack[neighborIndex]) {
//                return true;
//            }
//        }
//        recStack[index] = false;
//        return false;
//    }
//
//
//    private boolean dfsHasCycle(int index, int parentIndex, boolean visited[]) {
//        visited[index] = true;
//        List<Integer> adjacentVertices = edges.get(index);
//        for(Integer adjacentVertex: adjacentVertices) {
//            int adjIndex = vertices.indexOf(adjacentVertex);
//            if(!visited[adjacentVertex]) {
//                if(dfsHasCycle(adjIndex, index, visited)) {
//                    return true;
//                }
//            } else if(adjIndex != parentIndex) {
//                return true;
//            }
//        }
//        return false;
//    }
}
