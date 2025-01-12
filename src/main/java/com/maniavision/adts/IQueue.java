package com.maniavision.adts;

public interface IQueue {
    void add(int value);
    int remove();
    int peek();
    boolean isEmpty();
    int size();
}
