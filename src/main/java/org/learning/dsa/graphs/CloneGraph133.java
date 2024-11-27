package org.learning.dsa.graphs;

import java.util.*;

public class CloneGraph133 {
    public static void main(String[] args) {

    }

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;

            // Map to store the original node -> cloned node mapping
            Map<Node, Node> visited = new HashMap<>();

            // Start the recursive cloning process
            return getClone(node, visited);
        }

        private Node getClone(Node node, Map<Node, Node> visited) {
            // If the node has already been cloned, return the cloned node
            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            // Create a clone for the current node
            Node cloneNode = new Node(node.val);
            visited.put(node, cloneNode); // Mark the node as visited by storing it in the map

            // Recursively clone all neighbors
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(getClone(neighbor, visited));
            }

            return cloneNode;
        }
    }
}
