package com.maniavision.impl;

import com.maniavision.adts.IBinarySearchTree;

public class BinarySearchTreeRecursive implements IBinarySearchTree {
    private BinarySearchTreeNode root;

    public BinarySearchTreeRecursive() {
        root = null;
    }

    @Override
    public void add(int value) {
        root = addUtil(root, value);
    }

    private BinarySearchTreeNode addUtil(BinarySearchTreeNode node, int value) {
        if(node == null)
            node = new BinarySearchTreeNode(value);
        else if(value > node.data)
            node.right = addUtil(node.right, value);
        else
            node.left = addUtil(node.left, value);
        return node;
    }

    @Override
    public boolean search(int key) {
        return searchUtil(root, key);
    }

    private boolean searchUtil(BinarySearchTreeNode node, int key) {
        if(node == null)
            return false;
        else {
            if(key == node.data)
                return true;
            else if(key > node.data)
                return searchUtil(node.right, key);
            else
                return searchUtil(node.left, key);
        }
    }

    @Override
    public void remove(int value) {

    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void preOrderTraversal() {
        preOrder(root);
    }

    private void preOrder(BinarySearchTreeNode node) {
        if(node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    @Override
    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(BinarySearchTreeNode node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    @Override
    public void postOrderTraversal() {
        postOrder(root);
    }

    private void postOrder(BinarySearchTreeNode node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}
