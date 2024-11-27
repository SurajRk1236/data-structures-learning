package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumTimeTakenToBurnBinaryTreeGFG {
    public static void main(String[] args) {

    }

    private TreeNode mapParents(TreeNode root, Map<TreeNode, TreeNode> parentMap, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode targetNode = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == target) {
                targetNode = node;
            }
            if (node.left != null) {
                parentMap.put(node.left, node); // mapping parent of the left child
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node); // mapping parent of the right child
                queue.offer(node.right);
            }
        }

        return targetNode;
    }

    public int minTimeToBurn(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }

        // Step 1: Create a parent map to navigate upwards in the tree
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode = mapParents(root, parentMap, target);

        // Step 2: Perform BFS starting from the target node
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean spreadFire = false; // to track if fire spreads in the current level

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Visit the left child
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                    spreadFire = true;
                }

                // Visit the right child
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                    spreadFire = true;
                }

                // Visit the parent
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    queue.offer(parentMap.get(node));
                    visited.add(parentMap.get(node));
                    spreadFire = true;
                }
            }

            // If the fire spread in this level, increment the time
            if (spreadFire) {
                time++;
            }
        }

        return time;
    }
}
