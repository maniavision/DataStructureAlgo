package com.maniavision.impl;

import com.maniavision.adts.IQueue;

public class QueueLinkedList implements IQueue {
    private LinkedList list;

    public QueueLinkedList() {
        list = new LinkedList();
    }

    @Override
    public void add(int value) {

    }

    @Override
    public int remove() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
