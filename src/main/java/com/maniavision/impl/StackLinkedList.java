package com.maniavision.impl;

import com.maniavision.adts.IStack;

import java.util.EmptyStackException;

public class StackLinkedList implements IStack {
    private LinkedList list;

    public StackLinkedList() {
        list = new LinkedList();
    }
    @Override
    public void push(int value) {
        list.addFront(value);
    }

    @Override
    public int pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        int top = list.getHead().data;
        list.remove(top);
        return top;
    }

    @Override
    public int top() {
        if(isEmpty())
            throw new EmptyStackException();
        return list.getHead().data;
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
