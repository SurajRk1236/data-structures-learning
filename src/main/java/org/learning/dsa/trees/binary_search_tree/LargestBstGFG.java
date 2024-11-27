package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

public class LargestBstGFG {
    public static void main(String[] args) {

    }

    class SubtreeInfo {
        int size;  // Size of the largest BST subtree
        int min;   // Minimum value in the subtree
        int max;   // Maximum value in the subtree
        boolean isBST;  // Whether the subtree is a valid BST

        SubtreeInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    // Main function to find the largest BST in a binary tree
    public int largestBSTSubtree(TreeNode root) {
        SubtreeInfo result = largestBST(root);
        return result.size;
    }

    // Recursive function to find the largest BST in the subtree rooted at 'node'
    private SubtreeInfo largestBST(TreeNode node) {
        // Base case: empty tree is a valid BST of size 0
        if (node == null) {
            return new SubtreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        // Recursively find the largest BST in the left and right subtrees
        SubtreeInfo left = largestBST(node.left);
        SubtreeInfo right = largestBST(node.right);

        // Check if the current node is a valid BST with its left and right subtrees
        if (left.isBST && right.isBST && left.max < node.val && node.val < right.min) {
            // The current subtree is a valid BST
            int size = left.size + right.size + 1;
            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);
            return new SubtreeInfo(size, min, max, true);
        } else {
            // The current subtree is not a valid BST, return the larger BST size from left or right
            return new SubtreeInfo(Math.max(left.size, right.size), 0, 0, false);
        }
    }

    /**
     * public int largestBSTSubtree(TreeNode root) {
     *         return largestBST(root).size;
     *     }
     *
     *     // Recursive function to find the largest BST in the subtree rooted at 'node'
     *     private SubtreeInfo largestBST(TreeNode node) {
     *         // Base case: an empty tree is a valid BST with size 0
     *         if (node == null) {
     *             return new SubtreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
     *         }
     *
     *         // Recursively find the largest BST in the left and right subtrees
     *         SubtreeInfo left = largestBST(node.left);
     *         SubtreeInfo right = largestBST(node.right);
     *
     *         // Check if the current node and its left and right subtrees form a valid BST
     *         if (left.max < node.val && node.val < right.min) {
     *             // The current subtree is a valid BST
     *             int size = left.size + right.size + 1;
     *             int min = Math.min(node.val, left.min);
     *             int max = Math.max(node.val, right.max);
     *             return new SubtreeInfo(size, min, max);
     *         } else {
     *             // The current subtree is not a valid BST, return the larger BST size from left or right
     *             return new SubtreeInfo(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
     *         }
     *     }
     */

}
