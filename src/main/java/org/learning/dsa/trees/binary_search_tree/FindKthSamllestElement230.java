package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

public class FindKthSamllestElement230 {
    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        // Use an array to store the counter and result so that their values are updated
        // across recursive calls.
        int[] result = new int[1]; // Array to store the result (k-th smallest element)
        int[] counter = new int[1]; // Array to store the counter (number of visited nodes)

        inOrderTraversal(root, k, counter, result);
        return result[0];
    }

    private void inOrderTraversal(TreeNode root, int k, int[] counter, int[] result) {
        // Base case: if root is null, return
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(root.left, k, counter, result);

        // Process the current node
        counter[0]++; // Increment the counter
        if (counter[0] == k) {
            result[0] = root.val; // If counter matches k, store the result
            return; // No need to continue once we've found the k-th smallest element
        }

        // Traverse the right subtree
        inOrderTraversal(root.right, k, counter, result);
    }

    private void inOrderTraversalLargest(TreeNode root, int k, int[] counter, int[] result) {
        // Base case: if root is null, return
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(root.right, k, counter, result);

        // Process the current node
        counter[0]++; // Increment the counter
        if (counter[0] == k) {
            result[0] = root.val; // If counter matches k, store the result
            return; // No need to continue once we've found the k-th smallest element
        }

        // Traverse the right subtree
        inOrderTraversal(root.left, k, counter, result);
    }
}
