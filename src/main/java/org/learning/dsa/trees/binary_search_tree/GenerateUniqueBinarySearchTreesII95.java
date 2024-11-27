package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 *  check this properly do proper dry run of code
 */

public class GenerateUniqueBinarySearchTreesII95 {


    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return constructTrees(1, n);
    }

    private List<TreeNode> constructTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        // Base case: if the range is invalid, return a list with 'null' (represents an
        // empty tree)
        if (start > end) {
            result.add(null);
            return result;
        }

        // Try each number as the root of the tree
        for (int i = start; i <= end; i++) {
            // Recursively generate all possible left subtrees using values less than 'i'
            List<TreeNode> leftSubtrees = constructTrees(start, i - 1);

            // Recursively generate all possible right subtrees using values greater than
            // 'i'
            List<TreeNode> rightSubtrees = constructTrees(i + 1, end);

            // Combine left and right subtrees with the current root
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root); // Add the current combination of trees to the result
                }
            }
        }

        return result;
    }
}
