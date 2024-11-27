package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Initialize a queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Start BFS traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Get number of nodes in the current level
            List<Integer> currentLevel = new ArrayList<>();
            // List to hold nodes of the current level

            // Process each node in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                // Add left and right children to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add the current level to the result list
            result.add(currentLevel);
        }

        return result;
    }
}
