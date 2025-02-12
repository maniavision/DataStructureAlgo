package com.maniavision.impl;

import com.maniavision.adts.ITrie;

import java.util.ArrayList;
import java.util.List;

public class Trie implements ITrie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    @Override
    public void add(String key) {
        TrieNode curr = root;

        for(char c : key.toLowerCase().toCharArray()) {
            int charIndex = c - 'a';
            if(curr.child[charIndex] == null) {
                TrieNode newNode = new TrieNode();
                curr.child[charIndex] = newNode;
            }
            curr = curr.child[charIndex];
        }
        curr.isLastChar = true;
    }

    @Override
    public void remove(String key) {
        TrieNode curr = root;
        List<TrieNode> trieNodeList = new ArrayList<>();

        for(char c: key.toLowerCase().toCharArray()) {
            int charIndex = c - 'a';
            if(curr.child[charIndex] != null) {

            }
        }

    }

    @Override
    public boolean find(String key) {
        TrieNode curr = root;
        for(char c : key.toLowerCase().toCharArray()) {
            if(curr.child[c - 'a'] == null)
                return false;
            curr = curr.child[c - 'a'];
        }
        return curr.isLastChar;
    }

}
