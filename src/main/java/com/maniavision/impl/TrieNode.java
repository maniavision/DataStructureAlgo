package com.maniavision.impl;

public class TrieNode {
    private static final int CHAR_COUNT = 26;
    boolean isLastChar;
    TrieNode child[];

    public TrieNode() {
        child = new TrieNode[CHAR_COUNT];
        for(int i = 0; i < CHAR_COUNT; i++) {
            child[i] = null;
        }
        isLastChar = false;
    }
}
