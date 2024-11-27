package org.learning.dsa.tries;

import java.util.Stack;

public class LongestWordInDictionary720 {

    class Node {
        Node[] links; // Array to store 26 possible characters (a-z)
        boolean isEnd; // Flag to mark the end of a word
        String word;   // Stores the word at the end of a valid word

        Node() {
            links = new Node[26]; // Initialize links for 26 letters
            isEnd = false;        // Initially, no word is marked as ending here
            word = null;          // Word is null until a valid word ends here
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

        void setEnd(String word) {
            isEnd = true;
            this.word = word; // Store the word at the end of this node
        }

        boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }

        // Insert word into the Trie
        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.setEnd(word); // Mark the end of the word
        }

        // Perform DFS to find the longest word that can be built character by character
        public String findLongestWord() {
            String longestWord = "";
            Stack<Node> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                Node node = stack.pop();
                // Only consider nodes where a word ends
                if (node.isEnd || node == root) {
                    for (int i = 25; i >= 0; i--) { // Traverse in reverse lexicographical order
                        if (node.links[i] != null && node.links[i].isEnd()) {
                            stack.push(node.links[i]);
                        }
                    }

                    // Update the longest word if the current node has a valid word
                    if (node.word != null) {
                        if (node.word.length() > longestWord.length() ||
                                (node.word.length() == longestWord.length() && node.word.compareTo(longestWord) < 0)) {
                            longestWord = node.word;
                        }
                    }
                }
            }

            return longestWord;
        }
    }

    public class Solution {
        public String longestWord(String[] words) {
            Trie trie = new Trie();
            // Insert all words into the Trie
            for (String word : words) {
                trie.insert(word);
            }
            // Find the longest word
            return trie.findLongestWord();
        }
    }

}
