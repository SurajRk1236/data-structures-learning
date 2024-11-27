package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

public class BalancedBinaryTree110 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode root){
        if(root == null){
            return 0;
        }
        // Recursively calculate the
        // height of the left subtree
        int leftHeight = checkBalance(root.left);

        // If the left subtree is unbalanced,
        // propagate the unbalance status
        if (leftHeight == -1)
            return -1;

        // Recursively calculate the
        // height of the right subtree
        int rightHeight = checkBalance(root.right);

        // If the right subtree is unbalanced,
        // propagate the unbalance status
        if (rightHeight == -1)
            return -1;

        // Check if the difference in height between
        // left and right subtrees is greater than 1
        // If it's greater, the tree is unbalanced,
        // return -1 to propagate the unbalance status
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        // Return the maximum height of left and
        // right subtrees, adding 1 for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
