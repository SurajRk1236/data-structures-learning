package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree545 {
    public static void main(String[] args) {

    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return result;
        }
        addLeftBoundaryOfBinaryTree(root.left, result);
        addLeavesInorder(root, result);
        addRightBoundaryTraversal(root.right, result);
        return result;
    }

    private void addLeftBoundaryOfBinaryTree(TreeNode root, List<Integer> result) {
        while (root != null) {
            if (!checkLeaveNode(root)) {
                result.add(root.val);
            }
            if (root.left == null) {
                root = root.right;
            } else
                root = root.left;
        }
    }

    private boolean checkLeaveNode(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void addLeavesInorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        addLeavesInorder(root.left, result);
        if (checkLeaveNode(root))
            result.add(root.val);
        addLeavesInorder(root.right, result);
    }

    private void addRightBoundaryTraversal(TreeNode root, List<Integer> result) {
        List<Integer> newResult = new ArrayList<>();
        while (root != null) {
            if (!checkLeaveNode(root)) {
                newResult.add(root.val);
            }
            if (root.right == null) {
                root = root.left;
            } else
                root = root.right;
        }
        for (int i = newResult.size(); i > 0; i--) {
            result.add(newResult.get(i - 1));
        }
    }
}
