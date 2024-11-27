package org.learning.dsa.tries;

import java.util.List;

public class ReplaceWords648 {
    public static void main(String[] args) {

    }

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

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.isEnd = true;
        }

        String dicData(Node node, String sentence){
            int count = 0;
            String dictionaryData = "";
            for(int i = 0; i < sentence.length(); i++){
                char ch = sentence.charAt(i);
                if(node.containsKey(ch)){
                    dictionaryData += ch;
                    count++;
                    node = node.get(ch);
                }else{
                    break;
                }
            }
            return count == 0 ? sentence : dictionaryData;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        StringBuilder result = new StringBuilder();
        for (String dict : dictionary){
            trie.insert(dict);
        }

        String[] sentenceToWord = sentence.split(" ");
        for(String str : sentenceToWord){
            result.append(trie.dicData(trie.root, str)).append(" ");
        }

        return result.toString().trim();
    }
}
