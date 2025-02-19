package com.maniavision.impl;

import java.util.List;

public class Vertex <T>{
    public T value;
    public int parent;
    public int time;
    public VertexStatus status = VertexStatus.UNDISCOVERED;
}
