package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        // Call helper function with initial boundaries: (-∞, ∞)
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function to recursively validate the BST
    private boolean validate(TreeNode node, long low, long high) {
        // Base case: if node is null, it's a valid subtree
        if (node == null) {
            return true;
        }

        // If the node's value violates the current range, return false
        if (node.val <= low || node.val >= high) {
            return false;
        }

        // Recursively validate the left subtree and right subtree
        // For the left subtree, the valid range is (low, node.val)
        // For the right subtree, the valid range is (node.val, high)
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}
