package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

public class LowestCommonAncsestor235 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null
        if (root == null) {
            return null;
        }

        // If both p and q are smaller than root, LCA is in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If both p and q are greater than root, LCA is in the right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If one node is on the left and the other is on the right, root is the LCA
        return root;
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree iteratively
        while (root != null) {
            // If both p and q are smaller than root, move to the left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both p and q are greater than root, move to the right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // Otherwise, root is the LCA
            else {
                return root;
            }
        }
        return null;
    }
}
