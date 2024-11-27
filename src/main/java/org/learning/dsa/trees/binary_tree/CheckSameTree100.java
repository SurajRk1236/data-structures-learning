package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

public class CheckSameTree100 {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkForSameTree(p, q);
    }

    private boolean checkForSameTree(TreeNode p, TreeNode q){
        // If both nodes are null, they are the same
        if (p == null && q == null) {
            return true;
        }

        // If one of the nodes is null and the other isn't, they are not the same
        if (p == null || q == null) {
            return false;
        }

        // If both nodes have the same value, check their left and right subtrees
        if (p.val == q.val) {
            return checkForSameTree(p.left, q.left) && checkForSameTree(p.right, q.right);
        }

        // If the node values differ, the trees are not the same
        return false;
    }
}
