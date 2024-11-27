package org.learning.dsa.linked_list;

public class RemoveDuplicatesFromSortedLL83 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        // If the list is empty or has only one node, no duplicates to remove
        if (head == null || head.next == null) {
            return head;
        }

        // Start with the head of the list
        ListNode current = head;

        // Traverse the list
        while (current != null && current.next != null) {
            // If the current node's value is the same as the next node's value
            if (current.val == current.next.val) {
                // Skip the next node
                current.next = current.next.next;
            } else {
                // Otherwise, move to the next node
                current = current.next;
            }
        }

        // Return the modified list
        return head;
    }
}
