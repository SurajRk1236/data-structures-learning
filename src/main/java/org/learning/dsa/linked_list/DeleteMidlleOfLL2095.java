package org.learning.dsa.linked_list;

public class DeleteMidlleOfLL2095 {
    public static void main(String[] args) {

    }

    public ListNode deleteMiddle(ListNode head) {
        // Edge case: if there's only one node, return null
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To track the node before the middle

        // Traverse the list with slow and fast pointers
        while (fast != null && fast.next != null) {
            prev = slow; // Store the previous node
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2
        }

        // Now slow is at the middle, and prev is the node before the middle
        prev.next = slow.next; // Remove the middle node

        return head;
    }
}
