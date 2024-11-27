package org.learning.dsa.tries;

public class NumberOfMatchingSequence792 {
    public static void main(String[] args) {

    }

    class Node {
        Node[] links;
        boolean isEnd;

        Node() {
            links = new Node[26]; // For lowercase alphabet characters
            isEnd = false;
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

        // Insert a word into the Trie
        void insert(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.isEnd = true;
        }

        // DFS to search for matching subsequences
        boolean dfs(Node node, String s, int index) {
            if (node == null) return false;
            if (node.isEnd) return true; // If we've reached the end of a word

            for (int i = index; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (node.containsKey(ch)) {
                    if (dfs(node.get(ch), s, i + 1)) {
                        return true; // Found a matching subsequence
                    }
                }
            }
            return false;
        }
    }

    public class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            Trie trie = new Trie();

            // Insert all words into the Trie
            for (String word : words) {
                trie.insert(word);
            }

            int count = 0;
            // Traverse the Trie and check for matching subsequences
            for (String word : words) {
                if (trie.dfs(trie.root, s, 0)) {
                    count++;
                }
            }

            return count;
        }
    }

}
