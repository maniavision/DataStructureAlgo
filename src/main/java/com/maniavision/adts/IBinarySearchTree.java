package com.maniavision.adts;

public interface IBinarySearchTree {

    void add(int value);
    boolean search(int key);
    void remove(int value);
    boolean isEmpty();
    int size();
    void preOrderTraversal();
    void inOrderTraversal();
    void postOrderTraversal();
}
