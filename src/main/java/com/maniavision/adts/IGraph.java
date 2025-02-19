package com.maniavision.adts;

import com.maniavision.impl.Vertex;

import java.util.List;

public interface IGraph {
    void addVertex(Vertex vertex);
    boolean hasVertex(Vertex vertex);
    void addEdge(Vertex fromVertex, Vertex toVertex, int cost);
    List<Vertex> getVertices(Vertex vertex);
    boolean isEmpty();
    void depthFirstSearch(Vertex source);
    boolean depthFirstSearch(Vertex source, Vertex target);
    void breathFirstSearch(Vertex source);
    boolean breathFirstSearch(Vertex source, Vertex target);
    int connectedComponents();
    void topologicalSort();
    boolean hasCycle();
    void shortestPath(Vertex start, Vertex end);
}
