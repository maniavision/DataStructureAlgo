package com.maniavision;

import com.maniavision.adts.IGraph;
import com.maniavision.impl.AdjacencyListGraph;
import com.maniavision.impl.AdjacencyMatrixGraph;
import com.maniavision.problems.ListProblems;
import com.maniavision.problems.StringProblems;

import java.util.LinkedList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        IGraph g = new AdjacencyListGraph(false);
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);

        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 4, 1);
        g.addEdge(3, 4, 1);

        g.depthFirstSearch(0);
        System.out.println();
        g.breathFirstSearch(0);
        System.out.println();
        System.out.println(g.connectedComponents());

    }

    public static void problems() {
        System.out.println(StringProblems.OrderMatching("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "JOST"));
        System.out.println(StringProblems.UniqueCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        System.out.println(StringProblems.toUpper("abcd"));
        System.out.println(StringProblems.palindromeCheck("deed"));
        System.out.println(ListProblems.twoSumSortedArray(List.of(2, 3, 4, 5, 8, 11, 18), 8));
        System.out.println(ListProblems.removeDuplicatesV1(new LinkedList<>(List.of(0, 0, 1, 1, 1, 2, 2))));
        System.out.println(ListProblems.twoSumUnorderedList(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10));
    }
}