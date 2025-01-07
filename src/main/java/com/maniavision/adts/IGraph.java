package com.maniavision.adts;

import java.util.List;

public interface IGraph {
    void addVertex(int vertex);
    boolean hasVertex(int vertex);
    void addEdge(int fromVertex, int toVertex);
    List<Integer> getVertices(int vertex);
    boolean isEmpty();
    void depthFirstSearch();
    void breathFirstSearch();
}
