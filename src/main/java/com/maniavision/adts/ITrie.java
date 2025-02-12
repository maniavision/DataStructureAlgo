package com.maniavision.adts;

import com.maniavision.impl.TrieNode;

public interface ITrie {
    void add(String key);
//    TrieNode add(TrieNode curr, String str, int index);
    void remove(String key);
//    void remove(TrieNode curr, String str, int index);
    boolean find(String key);
//    boolean find(TrieNode curr, String str, int index);
}
