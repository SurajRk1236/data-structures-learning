package org.learning.dsa.tries;

public class PrefixSuffixSearch745 {
    public static void main(String[] args) {

    }

    class TrieNode {
        TrieNode[] children = new TrieNode[27];  // 26 letters + '#'
        int index = -1;
    }
    private TrieNode root;

    public PrefixSuffixSearch745(String[] words) {
        root = new TrieNode();

        // Insert all combinations of suffix + '#' + prefix into the Trie
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int wordLen = word.length();
            // For each word, add all combinations of (suffix + '#' + prefix)
            for (int i = 0; i <= wordLen; i++) {
                String suffix = word.substring(i);  // suffix from index i to the end
                String prefixSuffixCombo = suffix + "#" + word;
                insertIntoTrie(prefixSuffixCombo, index);
            }
        }
    }

    // Insert the word combination into the Trie with the corresponding index
    private void insertIntoTrie(String wordCombo, int index) {
        TrieNode node = root;
        for (char c : wordCombo.toCharArray()) {
            int charIndex = c == '#' ? 26 : (c - 'a');
            if (node.children[charIndex] == null) {
                node.children[charIndex] = new TrieNode();
            }
            node = node.children[charIndex];
            node.index = index;  // Keep updating with the current word's index
        }
    }


    // Search for the prefix + '#' + suffix combination in the Trie
    public int f(String prefix, String suffix) {
        String query = suffix + "#" + prefix;
        TrieNode node = root;
        for (char c : query.toCharArray()) {
            int charIndex = c == '#' ? 26 : (c - 'a');
            if (node.children[charIndex] == null) {
                return -1;  // If combination doesn't exist, return -1
            }
            node = node.children[charIndex];
        }
        return node.index;  // Return the highest index of the matched combination
    }
}
