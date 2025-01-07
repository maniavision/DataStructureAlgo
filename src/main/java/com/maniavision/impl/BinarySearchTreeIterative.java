package com.maniavision.impl;

import com.maniavision.adts.IBinarySearchTree;

public class BinarySearchTreeIterative implements IBinarySearchTree {
    private BinarySearchTreeNode root;

    public BinarySearchTreeIterative() {
        root = null;
    }

    @Override
    public void add(int value) {
        BinarySearchTreeNode newNode = new BinarySearchTreeNode(value);

        if(isEmpty())
            root = newNode;
        else {
            BinarySearchTreeNode curr = root;
            while(curr != null) {
                if(value > curr.data) {
                    if(curr.right == null) {
                        curr.right = newNode;
                        return;
                    }
                    curr = curr.right;
                } else if(value < curr.data){
                    if(curr.left == null) {
                        curr.left = newNode;
                        return;
                    }
                    curr = curr.left;
                } else
                    return;
            }
        }
    }

    @Override
    public boolean search(int key) {
        return false;
    }

    @Override
    public void remove(int value) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void preOrderTraversal() {

    }

    @Override
    public void inOrderTraversal() {

    }

    @Override
    public void postOrderTraversal() {

    }
}
