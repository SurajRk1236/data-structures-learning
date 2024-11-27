package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

public class RangeSumBST938 {
    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] result = new int[1];
        inOrderTraversal(root, low, high, result);
        return result[0];
    }

    private void inOrderTraversal(TreeNode root, int low, int high, int[] result) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree if possible
        if (root.val >= low) {
            inOrderTraversal(root.left, low, high, result);
        }

        // Add the node's value if it's in the range
        if (root.val >= low && root.val <= high) {
            result[0] += root.val;
        }

        // Traverse the right subtree if possible
        if (root.val <= high) {
            inOrderTraversal(root.right, low, high, result);
        }
    }
}
