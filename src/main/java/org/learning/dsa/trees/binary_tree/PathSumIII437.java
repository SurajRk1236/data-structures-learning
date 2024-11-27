package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.HashMap;

public class PathSumIII437 {
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int targetSum) {
        // Initialize the map with a base case (prefix sum of 0 has 1 occurrence)
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1);

        // Start DFS from the root
        return dfs(root, 0L, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }

        // Update the current sum
        currentSum += node.val;

        // Calculate the number of valid paths ending at the current node
        int numPaths = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        // Add the current sum to the map
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        // Recurse into the left and right subtrees
        numPaths += dfs(node.left, currentSum, targetSum, prefixSumMap);
        numPaths += dfs(node.right, currentSum, targetSum, prefixSumMap);

        // Backtrack: remove the current sum from the map after the recursion
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return numPaths;
    }
}
