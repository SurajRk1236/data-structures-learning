package org.learning.dsa.linked_list;

import org.learning.dsa.trees.TreeNode;

public class LLInBinaryTree1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false; // If we've reached the end of the tree
        }

        // Check if there's a matching subpath starting from the current node in the
        // tree
        if (dfs(head, root)) {
            return true;
        }

        // Continue to search in the left and right subtrees
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // Helper method to check if a path starting from the current TreeNode matches
    // the ListNode sequence
    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true; // We've successfully matched the entire linked list
        }

        if (root == null || root.val != head.val) {
            return false; // We've reached the end of the tree path or values don't match
        }

        // Check both left and right subtrees to continue matching the linked list
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}
