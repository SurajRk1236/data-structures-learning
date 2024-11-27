package org.learning.dsa.linked_list;

public class InsertionSortList147 {
    public static void main(String[] args) {

    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No sorting needed for empty or single-element lists
        }

        // Step 1: Create a dummy node to act as the starting point of the sorted list
        ListNode dummy = new ListNode(0); // Dummy node with a value of 0 (arbitrary)
        ListNode curr = head; // The current node we're trying to insert into the sorted part

        while (curr != null) {
            // Step 2: Find the position to insert the current node in the sorted part
            ListNode prev = dummy; // Start from the dummy node each time
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next; // Find the position to insert curr
            }

            // Step 3: Insert the current node into the sorted part
            ListNode nextTemp = curr.next; // Save the next node to process
            curr.next = prev.next;         // Link the current node to the sorted part
            prev.next = curr;              // Update the sorted part to include the current node
            curr = nextTemp;               // Move to the next node in the original list
        }

        return dummy.next; // The sorted list starts after the dummy node

    }
}
