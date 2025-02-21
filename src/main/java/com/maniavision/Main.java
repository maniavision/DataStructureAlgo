package com.maniavision;

import com.maniavision.adts.IGraph;
import com.maniavision.impl.GraphMatrix;
import com.maniavision.problems.ListProblems;
import com.maniavision.problems.StringProblems;

import java.util.LinkedList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        GraphMatrix<String> graph = new GraphMatrix<>(10, false);
        GraphMatrix<Integer> graph = new GraphMatrix<>(9, false);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);
//        setCountryUndirectedGraph(graph);
//        System.out.println(graph.outDegreeCount(4));
//        graph.print();
//        graph.depthFirstSearch();
        graph.primMST();
//        System.out.println(graph.outDegreeCount("London"));

    }

    public static void setCountryDirectedGraph(IGraph<String> graph) {

    }

    public static void setCountryUndirectedGraph(IGraph<String> graph) {
        graph.addVertex("London");
        graph.addVertex("Paris");
        graph.addVertex("Tokyo");
        graph.addVertex("NewYork");
        graph.addVertex("Toronto");
        graph.addVertex("San Francisco");
        graph.addVertex("Houston");
        graph.addVertex("Miami");
        graph.addVertex("Dakar");
        graph.addVertex("Lagos");

        graph.addEdge("London", "Tokyo");
        graph.addEdge("London", "Lagos");
        graph.addEdge("London", "NewYork");
        graph.addEdge("London", "Paris");
        graph.addEdge("Paris", "Dakar");
        graph.addEdge("Paris", "Toronto");
        graph.addEdge("Paris", "Miami");
        graph.addEdge("NewYork", "San Francisco");
        graph.addEdge("NewYork", "Toronto");
        graph.addEdge("NewYork", "Houston");
        graph.addEdge("NewYork", "Dakar");
        graph.addEdge("Houston", "Miami");
        graph.addEdge("Houston", "Lagos");
        graph.addEdge("Houston", "San Francisco");
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