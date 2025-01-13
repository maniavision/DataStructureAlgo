package com.maniavision;

import com.maniavision.adts.IBinarySearchTree;
import com.maniavision.adts.IList;
import com.maniavision.impl.ArrayList;
import com.maniavision.impl.BinarySearchTreeRecursive;
import com.maniavision.impl.LinkedList;
import com.maniavision.problems.StringProblems;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println(StringProblems.OrderMatching("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "JOST"));
        System.out.println(StringProblems.UniqueCharacters("ABCDEFGHIJKLMNOPQRSSTUVWXYZ"));
        System.out.println(StringProblems.toUpper("abcd"));
        System.out.println(StringProblems.palindromeCheck("deed"));
    }
}