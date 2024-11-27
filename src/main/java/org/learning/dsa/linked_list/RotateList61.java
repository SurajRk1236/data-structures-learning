package org.learning.dsa.linked_list;

public class RotateList61 {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        // Edge case: If the list is empty or contains only one node, or no rotations are needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the list and make it circular
        ListNode oldTail = head;
        int length = 1;  // Start length as 1 since we're counting the head
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        // Step 2: Connect the last node to the head to form a circular list
        oldTail.next = head;

        // Step 3: Find the new head after rotation (k % length) steps
        // If k is greater than the length, we only need to rotate (k % length) times
        int newTailPosition = length - (k % length) - 1;

        ListNode newTail = head;
        for (int i = 0; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        // Step 4: The new head is the node next to newTail
        ListNode newHead = newTail.next;

        // Step 5: Break the circular list
        newTail.next = null;

        return newHead;
    }
}
