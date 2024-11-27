package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }
        pathSumCheck(root, targetSum, new ArrayList<>());
        return result;
    }

    private void pathSumCheck(TreeNode root, int targetSum, List<Integer> temp) {
        if (root == null) return;

        // Add current node value to the path
        temp.add(root.val);

        // Check if current node is a leaf and if the current path sum equals target sum
        if (root.left == null && root.right == null && targetSum == root.val) {
            // Add a new copy of the current path to the result
            result.add(new ArrayList<>(temp));
        } else {
            // Recursively check the left and right subtrees with the updated sum
            pathSumCheck(root.left, targetSum - root.val, temp);
            pathSumCheck(root.right, targetSum - root.val, temp);
        }

        // Backtrack: remove the current node from the path
        temp.remove(temp.size() - 1);
    }
}
