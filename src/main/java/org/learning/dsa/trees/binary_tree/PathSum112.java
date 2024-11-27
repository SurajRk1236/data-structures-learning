package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

public class PathSum112 {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        int cuurentSum = 0;
        return hasPathSum(root, targetSum, cuurentSum);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int cuurentSum){
        if(root == null) return false;
        cuurentSum += root.val;
        if(cuurentSum == targetSum && root.left == null && root.right == null) return true;
        if(hasPathSum(root.left, targetSum, cuurentSum)) return true;
        if(hasPathSum(root.right, targetSum, cuurentSum)) return true;
        return false;
    }
}
