package org.learning.dsa.linked_list;

public class MergeNodesBetweenTwoZeroes2181 {
    public static void main(String[] args) {

    }

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0); // Dummy node to keep track of the new list's head
        ListNode newTail = dummy; // This will track the end of the newly merged list

        ListNode current = head.next; // Start from the node after the initial '0'
        int sum = 0; // Sum of nodes between two zeros

        while (current != null) {
            if (current.val != 0) {
                sum += current.val; // Keep adding values until we encounter another '0'
            } else {
                // When we hit a '0', we create a new node with the sum and reset the sum
                newTail.next = new ListNode(sum);
                newTail = newTail.next; // Move the tail to the newly created node
                sum = 0; // Reset sum for the next segment
            }
            current = current.next; // Move to the next node in the list
        }

        return dummy.next; // Return the merged list, skipping the dummy node
    }
}
