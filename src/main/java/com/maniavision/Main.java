package com.maniavision;

import com.maniavision.adts.IBinarySearchTree;
import com.maniavision.adts.IList;
import com.maniavision.impl.ArrayList;
import com.maniavision.impl.BinarySearchTreeRecursive;
import com.maniavision.impl.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        IBinarySearchTree tree = new BinarySearchTreeRecursive();
        tree.add(50);
        tree.add(30);
        tree.add(15);
        tree.add(20);
        tree.add(65);
        tree.add(60);
        tree.add(90);
        tree.remove(65);
        System.out.println("30 is found: " + tree.search(30));
        System.out.println("Size: " + tree.size());
        tree.inOrderTraversal();
    }
}