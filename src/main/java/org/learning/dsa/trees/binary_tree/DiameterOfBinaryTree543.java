package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

public class DiameterOfBinaryTree543 {
    public static void main(String[] args) {

    }


    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterTree(root);
        return maxDiameter;
    }

    private int diameterTree(TreeNode node){
        if(node == null){
            return 0;
        }
        // Recursively calculate the height of left and right subtrees
        int leftHeight = diameterTree(node.left);
        int rightHeight = diameterTree(node.right);

        // Update the maximum diameter if the path through this node is larger
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
