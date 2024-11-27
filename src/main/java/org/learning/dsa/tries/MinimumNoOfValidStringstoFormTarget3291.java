package org.learning.dsa.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNoOfValidStringstoFormTarget3291 {
    public static void main(String[] args) {

    }

    class TrieNode {
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[26];
        }

        boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        // Insert the word into the trie
        void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
        }

        // Search the target starting from index i, and return all valid lengths of prefixes found
        List<Integer> getPrefixes(String target, int startIndex) {
            List<Integer> validPrefixes = new ArrayList<>();
            TrieNode node = root;

            for (int i = startIndex; i < target.length(); i++) {
                char ch = target.charAt(i);
                if (!node.containsKey(ch)) {
                    break;
                }
                node = node.get(ch);
                validPrefixes.add(i - startIndex + 1);  // Record the length of the valid prefix
            }

            return validPrefixes;
        }
    }

    public class Solution {
        public int minValidStrings(String[] words, String target) {
            Trie trie = new Trie();

            // Insert all words into the trie
            for (String word : words) {
                trie.insert(word);
            }

            // DP array to store the minimum number of valid strings to form the target up to index i
            int[] dp = new int[target.length() + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0; // No strings needed to form an empty string

            // Traverse the target string
            for (int i = 0; i < target.length(); i++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    continue; // If dp[i] is unreachable, skip this index
                }

                // Get all valid prefixes starting from index i
                List<Integer> prefixes = trie.getPrefixes(target, i);
                for (int prefixLength : prefixes) {
                    dp[i + prefixLength] = Math.min(dp[i + prefixLength], dp[i] + 1);
                }
            }

            // If dp[target.length()] is still Integer.MAX_VALUE, it means the target cannot be formed
            return dp[target.length()] == Integer.MAX_VALUE ? -1 : dp[target.length()];
        }
    }

}
