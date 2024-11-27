package org.learning.dsa.trees.binary_tree;
import org.learning.dsa.trees.TreeNode;

public class SumRootToLeafNodes129 {

    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);
        return leftSum + rightSum;
    }
}
