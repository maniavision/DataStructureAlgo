package com.maniavision.impl;

import com.maniavision.adts.IGraph;

import java.util.List;

public class AdjacencyListGraph implements IGraph {
    @Override
    public void addVertex(int vertex) {

    }

    @Override
    public boolean hasVertex(int vertex) {
        return false;
    }

    @Override
    public void addEdge(int fromVertex, int toVertex, int cost) {

    }

    @Override
    public List<Integer> getVertices(int vertex) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean depthFirstSearch(int source, int target) {
        return false;
    }

    @Override
    public boolean breathFirstSearch(int source, int target) {
        return false;
    }
}
