package com.maniavision;

import com.maniavision.adts.IList;
import com.maniavision.impl.ArrayList;
import com.maniavision.impl.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        IList list = new LinkedList();
        list.add(25);
        list.add(12);
        list.add(77);
        list.add(54);
        System.out.println("Size: " + list.size());
        System.out.println("Is 12 found: " + list.search(12));
        System.out.println("Is 90 found: " + list.search(90));
        System.out.println("get elem at index 3: " + list.get(3));
        list.print();
        list.add(11);
        list.add(43);
        list.print();
    }
}