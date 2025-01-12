package com.maniavision.impl;

import com.maniavision.adts.IQueue;

public class QueueArrayList implements IQueue {
    private ArrayList list;

    public QueueArrayList() {
        list = new ArrayList();
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
