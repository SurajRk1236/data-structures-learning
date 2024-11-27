package org.learning.dsa.tries;

public class ImplementTrie208 {

    public static void main(String[] args) {

    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 26 letters for 'a' to 'z'
        boolean isEndOfWord = false; // Marks if a word ends at this node
    }

    private TrieNode root;

    public ImplementTrie208() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Map character to index (0-25)
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Create new node if doesn't exist
            }
            node = node.children[index]; // Move to the next node
        }
        node.isEndOfWord = true; // Mark end of the word
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null; // If node doesn't exist, return null
            }
            node = node.children[index]; // Move to the next node
        }
        return node; // Return the final node after traversing the prefix
    }
}
