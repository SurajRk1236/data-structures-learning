package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree662 {
    public static void main(String[] args) {

    }

    class Pair {
        int val;
        TreeNode node;
        Pair(TreeNode node, int val) {
            this.val = val;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Queue will store pairs of TreeNode and its position index in the binary tree
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = queue.peek().val; // Get the position of the first node in this level
            int end = start; // Track the last node's position

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int pos = pair.val;

                // Update the last node's position in this level
                end = pos;

                // Add left and right children with updated positions
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * pos));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * pos + 1));
                }
            }

            // Update the maximum width (end - start + 1)
            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth;
    }
}
