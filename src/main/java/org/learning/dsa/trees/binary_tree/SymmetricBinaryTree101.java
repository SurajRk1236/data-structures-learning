package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

public class SymmetricBinaryTree101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }

        if(left.val != right.val){
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
