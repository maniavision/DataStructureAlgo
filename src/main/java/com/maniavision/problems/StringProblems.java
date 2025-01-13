package com.maniavision.problems;

import java.util.HashSet;
import java.util.Set;

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
        char inputArray[] = input.toCharArray();
        int start = 0;
        int end = inputArray.length - 1;
        while(start < end && result) {
            if(inputArray[start] != inputArray[end])
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
        char inputArray[] = input.toCharArray();
        for(int i = 0; i < inputArray.length; ++i) {
            char ch = inputArray[i];
            char upperChar = (char)(ch - 32);
            result.append(upperChar);
        }
        return result.toString();
    }

    public static boolean UniqueCharacters(String input) {
        boolean hasUniqueCharacters = true;
        char inputArray[] = input.toCharArray();
        Set<Character> charCheckSet = new HashSet<>();

        int index = 0;
        while(index < inputArray.length && hasUniqueCharacters) {
            char ch = inputArray[index];
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
        char textArray[] = text.toCharArray();
        char patternArray[] = pattern.toCharArray();
        boolean isOrderMatching = false;
        int indexPattern = 0;
        int indexText = 0;

        while(indexText < textArray.length && !isOrderMatching) {
            if(textArray[indexText] == patternArray[indexPattern])
                indexPattern++;

            if(indexPattern == patternArray.length - 1)
                isOrderMatching = true;

            indexText++;
        }

        return isOrderMatching;
    }
}
