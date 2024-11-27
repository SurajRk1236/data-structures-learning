package org.learning.dsa.linked_list;

public class RemoveLLElements203 {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        // Step 1: Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(-1); // Dummy node with an arbitrary value
        dummy.next = head;

        // Step 2: Initialize a pointer to traverse the list
        ListNode current = dummy;

        // Step 3: Traverse the list and remove nodes with the target value
        while (current.next != null) {
            if (current.next.val == val) {
                // Remove the node by skipping it
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        // Step 4: Return the new head (dummy.next)
        return dummy.next;
    }
}
