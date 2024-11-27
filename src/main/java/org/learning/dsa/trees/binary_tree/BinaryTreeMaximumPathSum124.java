package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {

    }

    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0; // Base case: null node contributes nothing
        }

        // Recursively calculate the maximum path sum of the left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0); // If negative, ignore the subtree (use 0)
        int rightGain = Math.max(maxGain(node.right), 0); // If negative, ignore the subtree

        // Current path sum includes node value and both left and right gains
        int currentPathSum = node.val + leftGain + rightGain;

        // Update the global maximum path sum if the current path sum is larger
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum gain that this node can contribute to its parent (choose
        // one path)
        return node.val + Math.max(leftGain, rightGain);
    }
}
