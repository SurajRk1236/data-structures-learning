package org.learning.dsa.tries;

import java.util.ArrayList;
import java.util.List;

public class LexoGraphicalNumber386 {
    public static void main(String[] args) {

    }

    class Node{
        Node[] links;
        Node(){
            links = new Node[10];
        }
        boolean containsKey(int num){
            return links[num] != null;
        }

        Node get(int num){
            return links[num];
        }

        void put(int num, Node node){
            links[num] = node;
        }

    }

    class Trie{
        Node root;
        Trie(){
            root = new Node();
        }

        void insert(int num){
            String str = String.valueOf(num);
            Node node = root;
            for(int i = 0; i < str.length(); i++){
                int digit = str.charAt(i) - '0';
                if(!node.containsKey(digit)){
                    node.put(digit, new Node());
                }
                node = node.get(digit);
            }
        }

        void dfs(Node node, int currentNumber, List<Integer> result) {
            if (node == null) {
                return;
            }

            // Add the current number to the result list
            if (currentNumber != 0) {
                result.add(currentNumber);
            }

            // Traverse through the 10 possible digits (0-9)
            for (int i = 0; i < 10; i++) {
                if (node.containsKey(i)) {
                    dfs(node.get(i), currentNumber * 10 + i, result);
                }
            }
        }

    }
    public List<Integer> lexicalOrder(int n) {
        Trie trie = new Trie();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<n; i++){
            trie.insert(n);
        }

        trie.dfs(trie.root, 0, result);

        return result;
    }

    public List<Integer> lexicalOrderV2(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        // Start generating numbers from 1 to 9
        for (int start = 1; start <= 9; ++start) {
            generateLexicalNumbers(start, n, lexicographicalNumbers);
        }
        return lexicographicalNumbers;
    }

    private void generateLexicalNumbers(
            int currentNumber,
            int limit,
            List<Integer> result
    ) {
        // If the current number exceeds the limit, stop recursion
        if (currentNumber > limit) return;

        // Add the current number to the result
        result.add(currentNumber);

        // Try to append digits from 0 to 9 to the current number
        for (int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
            int nextNumber = currentNumber * 10 + nextDigit;
            // If the next number is within the limit, continue recursion
            if (nextNumber <= limit) {
                generateLexicalNumbers(nextNumber, limit, result);
            } else {
                break; // No need to continue if nextNumber exceeds limit
            }
        }
    }
}
