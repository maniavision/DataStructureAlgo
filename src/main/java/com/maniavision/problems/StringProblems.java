package com.maniavision.problems;

import java.util.*;

public class StringProblems {
    public static String ORDER_MATCHING_PROBLEM = "In a given long string and a pattern, find if the " +
            "characters of the pattern string are in the same order in the text string";
    public static String UNIQUE_CHARACTERS = "Write a function that will take a string as input and return true " +
            "if it contains all unique characters, else returns false";
    public static String TO_UPPER = "Write a function to convert small case characters of English " +
            "alphabets to large case characters";
    public static String PALINDROME_CHECK = "Find if the string is a palindrome or not";

    public static boolean palindromeCheck(String input) {
        boolean result = true;
        int start = 0;
        int end = input.length() - 1;
        while(start < end && result) {
            if(input.charAt(start) != input.charAt(end))
                result = false;
            else {
                start++;
                end--;
            }
        }
        return result;
    }

    public static String toUpper(String input) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            char upperChar = (char)(ch - 32);
            result.append(upperChar);
        }
        return result.toString();
    }

    public static boolean UniqueCharacters(String input) {
        boolean hasUniqueCharacters = true;
        Set<Character> charCheckSet = new HashSet<>();

        int index = 0;
        while(index < input.length() && hasUniqueCharacters) {
            char ch = input.charAt(index);
            if(charCheckSet.contains(ch))
                hasUniqueCharacters = false;
            else {
                charCheckSet.add(ch);
                index++;
            }
        }

        return hasUniqueCharacters;
    }
    public static boolean OrderMatching(String text, String pattern) {
        boolean isOrderMatching = false;
        int indexPattern = 0;
        int indexText = 0;

        while(indexText < text.length() && !isOrderMatching) {
            if(text.charAt(indexText) == pattern.charAt(indexPattern))
                indexPattern++;

            if(indexPattern == pattern.length() - 1)
                isOrderMatching = true;

            indexText++;
        }

        return isOrderMatching;
    }
}
