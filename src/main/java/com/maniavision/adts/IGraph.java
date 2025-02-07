package com.maniavision.adts;

import java.util.List;

public interface IGraph {
    void addVertex(int vertex);
    boolean hasVertex(int vertex);
    void addEdge(int fromVertex, int toVertex, int cost);
    List<Integer> getVertices(int vertex);
    boolean isEmpty();
    void depthFirstSearch(int source);
    boolean depthFirstSearch(int source, int target);
    void breathFirstSearch(int source);
    boolean breathFirstSearch(int source, int target);
    int connectedComponents();
    void topologicalSort();
}
