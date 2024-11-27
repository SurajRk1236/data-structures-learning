package org.learning.dsa.tries;

import java.util.ArrayList;
import java.util.List;

public class ConcanetatedWords472 {
    public static void main(String[] args) {

    }

    class Node {
        Node[] links;
        boolean isEnd = false;

        Node() {
            links = new Node[26];
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.containsKey(word.charAt(i))) {
                    node.put(word.charAt(i), new Node());
                }
                node.isEnd = false;
                node = node.get(word.charAt(i));
            }
            node.isEnd = true;
        }

        boolean search(String word, int start, int count, Trie trie) {
            Node node = root;
            for (int i = start; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
                if (node.isEnd) {
                    // If we have reached the end of the word, check if the remaining part is also in the Trie
                    if (i == word.length() - 1) {
                        return count >= 1;  // We need at least one more word to consider this a concatenated word
                    }
                    // Recursively search the remaining part of the word
                    if (search(word, i + 1, count + 1, trie)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            trie.insert(word);
        }
        for (String word : words) {
            if (!word.isEmpty()) {
                trie.insert(word);
            }
        }

        // For each word, check if it is a concatenated word
        for (String word : words) {
            if (!word.isEmpty() && trie.search(word, 0, 0, trie)) {
                result.add(word);
            }
        }

        return result;
    }
}
