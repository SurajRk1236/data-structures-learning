package org.learning.dsa.tries;

public class ImplementMagicDictionary676 {
    public static void main(String[] args) {

    }

    class MagicDictionary {
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

        private Node root;

        public MagicDictionary() {
            root = new Node();
        }

        // Build the dictionary by inserting each word into the trie
        public void buildDict(String[] dictionary) {
            for (String str : dictionary) {
                Node node = root;
                for (char ch : str.toCharArray()) {
                    if (!node.containsKey(ch)) {
                        node.put(ch, new Node());
                    }
                    node = node.get(ch);
                }
                node.isEnd = true;
            }
        }

        // Search for the word with exactly one character mismatch
        public boolean search(String searchWord) {
            return checkRecursively(root, searchWord, 0, 0);
        }

        private boolean checkRecursively(Node node, String searchWord, int index, int mismatch) {
            if (node == null) return false;

            if (index == searchWord.length()) {
                return node.isEnd && mismatch == 1;
            }

            char ch = searchWord.charAt(index);

            // Try matching the character at the current position
            if (node.containsKey(ch)) {
                if (checkRecursively(node.get(ch), searchWord, index + 1, mismatch)) {
                    return true;
                }
            }

            // Try all possible mismatches by checking all other characters
            if (mismatch == 0) {
                for (int i = 0; i < 26; i++) {
                    char newChar = (char) ('a' + i);
                    if (newChar != ch && node.containsKey(newChar)) {
                        if (checkRecursively(node.get(newChar), searchWord, index + 1, mismatch + 1)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

}
