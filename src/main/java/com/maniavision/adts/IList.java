package com.maniavision.adts;

public interface IList {
    void add(int value);
    int get(int index);
    int search(int value);
    boolean remove(int value);
    int size();
    boolean isEmpty();
    void print();
}
