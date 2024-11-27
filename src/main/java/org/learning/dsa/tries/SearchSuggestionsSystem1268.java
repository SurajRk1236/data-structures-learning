package org.learning.dsa.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem1268 {
    public static void main(String[] args) {

    }

    class TrieNode {
        TrieNode[] children;
        List<String> suggestions;

        public TrieNode() {
            children = new TrieNode[26];
            suggestions = new ArrayList<>();
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                // Add the word to suggestions if less than 3 are already present
                if (node.suggestions.size() < 3) {
                    node.suggestions.add(word);
                }
            }
        }

        // Gets the suggestions for a given prefix
        public List<String> getSuggestions(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    return new ArrayList<>(); // No match for the prefix
                }
                node = node.children[idx];
            }
            return node.suggestions;
        }
    }

    class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Trie trie = new Trie();
            // Sort the products lexicographically
            Arrays.sort(products);

            // Insert each product into the Trie
            for (String product : products) {
                trie.insert(product);
            }

            // Prepare the result list
            List<List<String>> result = new ArrayList<>();
            StringBuilder prefix = new StringBuilder();

            // For each prefix of searchWord, get suggestions
            for (char c : searchWord.toCharArray()) {
                prefix.append(c);
                result.add(trie.getSuggestions(prefix.toString()));
            }

            return result;
        }
    }

}
