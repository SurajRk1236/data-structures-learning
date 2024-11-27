package org.learning.dsa.tries;

import java.util.HashMap;

public class CountPrefixSuffixSumPairs3042 {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private TrieNode prefixTrie;
    private TrieNode suffixTrie;

    public CountPrefixSuffixSumPairs3042() {
        prefixTrie = new TrieNode();
        suffixTrie = new TrieNode();
    }

    public int countPrefixSuffixPairs(String[] words) {
        // Insert all words into prefix Trie
        for (String word : words) {
            insert(word, prefixTrie);
        }

        // Insert reversed words into suffix Trie
        for (String word : words) {
            insert(reverse(word), suffixTrie);
        }

        int count = 0;
        // Now for each word, check if it's both a prefix and a suffix
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    // Function to insert a word into a Trie
    private void insert(String word, TrieNode root) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    // Function to check if str1 is both a prefix and a suffix of str2
    private boolean isPrefixAndSuffix(String prefix, String suffix) {
        return search(prefix, prefixTrie) && search(reverse(suffix), suffixTrie);
    }

    // Function to search if a word exists in a Trie
    private boolean search(String word, TrieNode root) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isEndOfWord;
    }

    // Function to reverse a string
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
