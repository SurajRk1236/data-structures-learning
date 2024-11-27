package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.Stack;

public class TwoSumBSTIV653 {
    public static void main(String[] args) {

    }

    private Stack<TreeNode> leftStack = new Stack<>();
    private Stack<TreeNode> rightStack = new Stack<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        // Initialize the stacks with leftmost and rightmost elements
        pushAllLeft(root);
        pushAllRight(root);

        return checkForSum(k);
    }

    // Push all left children to leftStack
    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            leftStack.push(root);
            root = root.left;
        }
    }

    // Push all right children to rightStack
    private void pushAllRight(TreeNode root) {
        while (root != null) {
            rightStack.push(root);
            root = root.right;
        }
    }

    // Get the next smallest value (in-order traversal)
    private int getNext() {
        TreeNode node = leftStack.pop();
        pushAllLeft(node.right);
        return node.val;
    }

    // Get the next largest value (reverse in-order traversal)
    private int getPrev() {
        TreeNode node = rightStack.pop();
        pushAllRight(node.left);
        return node.val;
    }

    // Check if the two-pointer technique can find the target sum
    private boolean checkForSum(int k) {
        int leftValue = getNext();
        int rightValue = getPrev();

        // Use two-pointer approach to find the sum
        while (leftValue < rightValue) {
            int currentSum = leftValue + rightValue;
            if (currentSum == k) {
                return true;
            } else if (currentSum < k) {
                leftValue = getNext();
            } else {
                rightValue = getPrev();
            }
        }

        return false;
    }
}
