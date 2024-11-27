package org.learning.dsa.tries;

public class TrieNode {
    private static final int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    // isEndOfWord is true if the node represents
    // end of a word
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
    }

    TrieNode(TrieNode root) {
    }
}
