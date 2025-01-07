package com.maniavision.impl;

import com.maniavision.adts.IList;

public class ArrayList implements IList {
    private static int DEFAULT_CAPACITY = 10;
    private int array[];
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        array = new int[capacity];
        size = 0;
    }
    @Override
    public void add(int value) {
        if(size() >= array.length) {
            doubleCapacity();
        }
        array[size++] = value;
    }

    private void doubleCapacity() {
        int elem[] = new int[array.length * 2];

        for(int i = 0; i < array.length; ++i) {
            elem[i] = array[i];
        }
        array = elem;
    }

    @Override
    public int get(int index) {
        if(index < 0 && index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public int search(int value) {
        for(int i = 0; i < array.length; ++i) {
            if(value == array[i])
                return i;
        }
        return -1;
    }

    @Override
    public boolean remove(int value) {
        int index = search(value);
        if(index != -1) {

            for(int i = index; i < array.length -1; ++i) {
                array[i] = array[i + 1];
            }
            --size;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void print() {
        for(int i = 0; i < size(); ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
