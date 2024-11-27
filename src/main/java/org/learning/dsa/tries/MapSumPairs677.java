package org.learning.dsa.tries;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs677 {

    class MapSum {

        class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            int value; // To store the cumulative value for prefix sum.
        }

        private TrieNode root;
        private Map<String, Integer> map; // Store the original key-value pairs.

        public MapSum() {
            root = new TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0); // Compute the difference in value for updating the trie.
            map.put(key, val); // Update the map with the new value.

            TrieNode node = root;
            for (char c : key.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
                node.value += delta; // Update the cumulative sum at this node.
            }
        }

        public int sum(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return 0; // If the prefix doesn't exist, return 0.
                }
                node = node.children.get(c);
            }
            return node.value; // Return the cumulative sum at the end of the prefix.
        }


    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
