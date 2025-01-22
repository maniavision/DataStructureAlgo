package com.maniavision.problems;

import java.util.*;

public class ListProblems {

    public static String TWO_SUM_SORTED_LIST = "Given an array of integers sorted in ascending order," +
            "find two numbers that add up to a given target. Return the indices of the two number in" +
            " ascending order. Elements are unique and there is only one solution.";
    public static String MOVE_ZEROS = "Given an array of integers, move all the 0s to the back of the array " +
            "while maintaining the relative order of the non-zero elements. Do this in-place using constant " +
            "auxiliary space.";
    public static String REMOVE_DUPLICATES = "Given a sorted list of numbers, remove duplicates and return the " +
            "new length. You must do this in-place and without using extra memory.";

    public static Map<Integer, Integer> twoSumUnorderedList(int input[], int target) {
        Set<Integer> set = new HashSet<>();
        for(int elem: input) {
            int delta = target - elem;
            if(set.contains(delta))
                return Map.of(elem, delta);
            else
                set.add(elem);
        }
        return Map.of();
    }
    public static int removeDuplicatesV1(List<Integer> input) {
        int index = 0;

        while(index < input.size() - 1) {
           if(input.get(index) == input.get(index + 1))
               input.remove(index + 1);
           else
               index++;
        }

        return input.size();
    }
    public static int removeDuplicatesV2(List<Integer> input) {
        if(input.size() < 2)
            return input.size();

        int index1 = 0;
        int index2 = 1;

        while(index1 < input.size()) {
            while(index2 < input.size() && input.get(index1) == input.get(index2)) {
                input.remove(index2);
            }
            index1 = index2;
            index2 = index1 + 1;
        }
        return input.size();
    }
    public static Integer[] moveZeros(Integer input[]) {

        int fist = 0;
        int last = 0;

        while(fist < input.length) {
            while(input[fist] != 0)
                fist++;

            if(input[fist] == 0) {
                int temp = fist + 1;
                while(input[temp] != 0)
                    temp++;

            }
        }
        return input;
    }

    public static Map<Integer, Integer> twoSumSortedArray(List<Integer> sortedList, int target) {
        Map<Integer, Integer> answer = new HashMap<>();

        if(sortedList.isEmpty() || sortedList.size() < 2)
            return answer;

        int index1 = 0;
        int index2 = 1;

        while(index1 < sortedList.size() && index2 < sortedList.size()) {
            int total = sortedList.get(index1) + sortedList.get(index2);
            if(target > total) {
                index2++;
            } else if(target < total) {
                index1++;
                index2 = index1 + 1;
            } else {
                answer.put(sortedList.get(index1), sortedList.get(index2));
                break;
            }
        }

        return answer;
    }
}
