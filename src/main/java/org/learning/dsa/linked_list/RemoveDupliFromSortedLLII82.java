package org.learning.dsa.linked_list;

public class RemoveDupliFromSortedLLII82 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        // Edge case: if the list is empty or contains a single element, return it
        if (head == null || head.next == null) {
            return head;
        }

        // Create a dummy node to handle edge cases and simplify pointer handling
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 'prev' is the last node before the group of duplicates
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // Check if current is a duplicate by comparing it with the next node
            if (current.next != null && current.val == current.next.val) {
                // Skip all nodes with the same value
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Connect 'prev.next' to 'current.next' to remove the duplicate nodes
                prev.next = current.next;
            } else {
                // No duplicates found, move 'prev' forward
                prev = prev.next;
            }
            // Move 'current' forward
            current = current.next;
        }

        // Return the modified list starting from the dummy node's next pointer
        return dummy.next;
    }
}
