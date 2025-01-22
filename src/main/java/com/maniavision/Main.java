package com.maniavision;

import com.maniavision.adts.IBinarySearchTree;
import com.maniavision.adts.IList;
import com.maniavision.impl.BinarySearchTreeRecursive;
import com.maniavision.problems.ListProblems;
import com.maniavision.problems.StringProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println(StringProblems.OrderMatching("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "JOST"));
        System.out.println(StringProblems.UniqueCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        System.out.println(StringProblems.toUpper("abcd"));
        System.out.println(StringProblems.palindromeCheck("deed"));
        System.out.println(ListProblems.twoSumSortedArray(List.of(2, 3, 4, 5, 8, 11, 18), 8));
        System.out.println(ListProblems.removeDuplicatesV1(new LinkedList<>(List.of(0, 0, 1, 1, 1, 2, 2))));
        System.out.println(ListProblems.twoSumUnorderedList(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10));
    }
}