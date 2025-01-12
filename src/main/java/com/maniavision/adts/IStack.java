package com.maniavision.adts;

import java.util.EmptyStackException;

public interface IStack {
    void push(int value);
    int pop() throws EmptyStackException;
    int top();
    boolean isEmpty();
    int size();
}
