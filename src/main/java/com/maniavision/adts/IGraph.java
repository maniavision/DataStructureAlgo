package com.maniavision.adts;

import com.maniavision.impl.Vertex;

import java.util.List;

public interface IGraph <T>{
    void addVertex(T newVertex);
    void removeVertex(T key);
    boolean hasVertex(T vertex);
    void addEdge(T fromVertex, T toVertex, int weight);
    void addEdge(T fromVertex, T toVertex);
    List<T> getNeighbors(T vertex);
    boolean isEmpty();
    int degreeCount(T vertex);
    int inDegreeCount(T vertex);
    int outDegreeCount(T vertex);
    void depthFirstSearch();
    void depthFirstSearch(T sourceVertex);
    boolean depthFirstSearch(T sourceVertex, T targetVertex);
    void breathFirstSearch();
    void breathFirstSearch(T sourceVertex);
    boolean breathFirstSearch(T sourceVertex, T targetVertex);
    int componentsCount();
    void topologicalSort();
    boolean hasCycle();
    void shortestPath(T fromVertex, T toVertex);
}
