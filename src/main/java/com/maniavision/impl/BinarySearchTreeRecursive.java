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
        else if(value < node.data)
            node.left = addUtil(node.left, value);
        else
            ; // Duplicate; do nothing
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
        boolean isPresent = search(value);
        if(isPresent) {
            root = removeUtil(root, value);
        }
    }

    private BinarySearchTreeNode removeUtil(BinarySearchTreeNode node, int target) {
        if(node == null)
            return null;

        if(target > node.data)
            node.right = removeUtil(node.right, target);
        else if(target < node.data)
            node.left = removeUtil(node.left, target);
        else if(node.left != null && node.right != null) {
            node.data = findMax(node.left).data;
            node.left = removeUtil(node.left, node.data);
        } else
            node = (node.left != null) ? node.left: node.right;

        return node;
    }

    private BinarySearchTreeNode findMax(BinarySearchTreeNode node) {
        if(node == null)
            return node;
        else if(node.right == null)
            return node;
        else
            return findMax(node.right);
    }

    private BinarySearchTreeNode findMin(BinarySearchTreeNode node) {
        if(node == null)
            return null;
        else if(node.right == null)
            return node;
        else
            return findMin(node.right);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return sizeUtil(root);
    }

    private int sizeUtil(BinarySearchTreeNode node) {
        if(node == null)
            return 0;
        return 1 + sizeUtil(node.left) + sizeUtil(node.right);
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
