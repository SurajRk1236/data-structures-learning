package org.learning.dsa.tries;

public class ShortEncodingOfWords820 {
    public static void main(String[] args) {

    }

    class Node {
        Node[] links;

        Node() {
            links = new Node[26];  // For storing 'a' to 'z'
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

        boolean isLeaf() {
            for (Node link : links) {
                if (link != null) {
                    return false;
                }
            }
            return true;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        // Insert a word into the Trie in reverse order
        void insert(String word) {
            Node node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
        }

        // DFS to find all leaf nodes and compute the encoding length
        int calculateEncodingLength(Node node, int depth) {
            if (node == null) {
                return 0;
            }

            // If the node is a leaf, return its depth (word length + 1 for the '#')
            if (node.isLeaf()) {
                return depth + 1;
            }

            int totalLength = 0;
            for (int i = 0; i < 26; i++) {
                if (node.links[i] != null) {
                    totalLength += calculateEncodingLength(node.links[i], depth + 1);
                }
            }
            return totalLength;
        }
    }

    public class Solution {
        public int minimumLengthEncoding(String[] words) {
            Trie trie = new Trie();

            // Insert each word in reverse into the Trie
            for (String word : words) {
                trie.insert(word);
            }

            // Perform DFS on the Trie to calculate the minimum encoding length
            return trie.calculateEncodingLength(trie.root, 0);
        }
    }

}
