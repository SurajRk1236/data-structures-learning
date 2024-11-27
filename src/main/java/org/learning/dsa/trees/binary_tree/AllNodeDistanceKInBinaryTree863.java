package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodeDistanceKInBinaryTree863 {
    public static void main(String[] args) {

    }

    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || target == null) {
            return result;
        }

        // Step 1: Build the parent mapping for each node
        buildParentMap(root, null);

        // Step 2: Perform BFS starting from the target node
        bfs(target, k, result);

        return result;
    }

    // Helper function to build the parent map using DFS
    private void buildParentMap(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        parentMap.put(node, parent);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }

    // BFS to find all nodes at distance K
    private void bfs(TreeNode target, int K, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == K) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return; // No need to process further once we reach distance K
            }
            distance++;

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Visit the left child
                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                // Visit the right child
                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                // Visit the parent
                TreeNode parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
        }
    }
}
