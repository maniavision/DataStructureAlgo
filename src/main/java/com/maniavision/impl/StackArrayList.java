package com.maniavision.impl;

import com.maniavision.adts.IStack;

import java.util.EmptyStackException;

public class StackArrayList implements IStack {
    private ArrayList list;
    public StackArrayList() {
        list = new ArrayList();
    }
    @Override
    public void push(int value) {
        list.add(value);
    }

    @Override
    public int pop() throws EmptyStackException {
        if(list.isEmpty())
            throw new EmptyStackException();
        int top = list.get(list.size() - 1);
        list.remove(top);
        return top;
    }

    @Override
    public int top() {
        if(list.isEmpty())
            throw new EmptyStackException();
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
