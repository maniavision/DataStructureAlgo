package com.maniavision.impl;

import com.maniavision.adts.IBinarySearchTree;

import java.util.ArrayDeque;

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
        boolean found = false;
        if(!isEmpty()) {
            BinarySearchTreeNode curr = root;
            while(curr != null && !found) {
                if(key > curr.data)
                    curr = curr.right;
                else if(key < curr.data)
                    curr = curr.left;
                else
                    found = true;
            }
        }
        return found;
    }

    @Override
    public void remove(int value) {
        boolean isPresent = search(value);
        if(isPresent) {
            BinarySearchTreeNode parent = null;
            BinarySearchTreeNode curr = root;

            while(curr != null) {
                if(value > curr.data) {
                    parent = curr;
                    curr = curr.right;
                } else if(value < curr.data) {
                    parent = curr;
                    curr = curr.left;
                } else
                    break; // found
            }

            if(curr == root) // root node
                curr = null;

            if(curr.left == null || curr.right == null) { // leaf or node with one child
                if(curr == parent.right)
                    parent.right = (curr.right == null) ? curr.left: curr.right;
                else
                    parent.left = (curr.right == null) ? curr.left: curr.right;
            } else {
                BinarySearchTreeNode predecessor = curr.left;
                BinarySearchTreeNode p = null;
                while(predecessor.right != null) {
                    p = predecessor;
                    predecessor = predecessor.right;
                }
                curr.data = predecessor.data;

                if(p == null) // p == null means that predecessor is left child
                    curr.left = null;
                else
                    p.right = predecessor.left; // predecessor can only have left child
            }
        }
    }

    private BinarySearchTreeNode parentOfPredecessor(BinarySearchTreeNode node) {
        BinarySearchTreeNode temp = node;
        while(temp.right.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    private BinarySearchTreeNode parentOfSuccessor(BinarySearchTreeNode node) {
        BinarySearchTreeNode temp = node;
        while(temp.left.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        int counter = 0;
        if(!isEmpty()) {
            ArrayDeque<BinarySearchTreeNode> q = new ArrayDeque<>();
            q.offer(root);

            while(!q.isEmpty()) {
                counter++;
                BinarySearchTreeNode node = q.remove();

                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
        }
        return counter;
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

    public void levelTraversal() {
        if(!isEmpty()) {
            ArrayDeque<BinarySearchTreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while(!isEmpty()) {
                BinarySearchTreeNode node = queue.remove();
                System.out.print(node.data + " ");

                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
    }

    public boolean isValidBST() {
        boolean isValidBST = false;

        return isValidBST;
    }
}
