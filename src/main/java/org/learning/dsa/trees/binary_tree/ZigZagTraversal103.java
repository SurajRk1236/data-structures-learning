package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal103 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> data = new LinkedList<>(); // Using LinkedList for efficient insertion

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                // If we are traversing left to right, add to the end of the list
                if (leftToRight) {
                    data.add(currentNode.val);
                } else {
                    // If we are traversing right to left, add to the front of the list
                    data.addFirst(currentNode.val);
                }

                // Add children to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(data); // Add the current level to the result
            leftToRight = !leftToRight; // Toggle the flag for the next level
        }
        return result;
    }
}
