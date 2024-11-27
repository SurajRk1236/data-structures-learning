package org.learning.dsa.tries;

public class DesignAddAndSearchWord211 {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;  // Mark end of the word
    }

    private TrieNode root;

    public DesignAddAndSearchWord211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();  // Create a new node if doesn't exist
            }
            node = node.children[index];
        }
        node.isWord = true;  // Mark the end of the word
    }

    public boolean search(String word) {
        return searchInNode(word, root, 0);
    }

    // Helper function to search recursively in the Trie
    private boolean searchInNode(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isWord;  // If we've reached the end of the word
        }
        char c = word.charAt(index);

        if (c == '.') {
            // If it's a dot, we need to check all possible children
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && searchInNode(word, node.children[i], index + 1)) {
                    return true;
                }
            }
            return false;  // If no match found
        } else {
            // If it's a regular character, just proceed in the Trie
            int charIndex = c - 'a';
            return node.children[charIndex] != null && searchInNode(word, node.children[charIndex], index + 1);
        }
    }
}
