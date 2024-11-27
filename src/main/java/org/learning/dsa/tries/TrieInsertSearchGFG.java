package org.learning.dsa.tries;

public class TrieInsertSearchGFG {
    public static void main(String[] args) {

    }

    static void insert(TrieNode root, String key) {
        TrieNode current = root;

        for (char ch : key.toCharArray()) {
            int index = ch - 'a';  // Find the index for the current character
            if (current.children[index] == null) {
                // If the character is not already present, create a new node
                current.children[index] = new TrieNode();
            }
            current = current.children[index];  // Move to the next node
        }
        // Mark the end of the word
        current.isEndOfWord = true;
    }

    // Function to search for a string in the Trie
    static boolean search(TrieNode root, String key) {
        TrieNode current = root;

        for (char ch : key.toCharArray()) {
            int index = ch - 'a';  // Find the index for the current character
            if (current.children[index] == null) {
                // If a character is missing in the Trie, return false
                return false;
            }
            current = current.children[index];  // Move to the next node
        }
        // After traversing all characters, check if it is marked as the end of a word
        return current.isEndOfWord;
    }
}
