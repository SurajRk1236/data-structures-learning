package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

public class ConvertSortedListBinarySearchTree109 {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {

        // Base case: if the list is empty, return null
        if (head == null)
            return null;

        // Base case: if there is only one node, create a TreeNode and return
        if (head.next == null)
            return new TreeNode(head.val);

        // Find the middle node of the list to be the root
        ListNode mid = findMiddleNode(head);

        // Create the root TreeNode with the middle node value
        TreeNode root = new TreeNode(mid.val);

        // Recursively build the left and right subtrees
        root.left = sortedListToBST(head); // Left subtree from the start of the list to the middle
        root.right = sortedListToBST(mid.next); // Right subtree from the middle+1 to the end

        return root;
    }

    // Helper function to find the middle of the list
    private ListNode findMiddleNode(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // Use slow and fast pointers to find the middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the left half of the list from the middle
        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }



}
