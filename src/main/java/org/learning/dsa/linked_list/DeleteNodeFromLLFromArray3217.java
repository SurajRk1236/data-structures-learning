package org.learning.dsa.linked_list;

import java.util.HashSet;

public class DeleteNodeFromLLFromArray3217 {
    public static void main(String[] args) {

    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        // Step 1: Store the values to delete in a HashSet for O(1) lookups
        HashSet<Integer> deleteSet = new HashSet<>();
        for (int val : nums) {
            deleteSet.add(val);
        }

        // Step 2: Initialize dummy node to handle edge cases with head deletion
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        // Step 3: Traverse the linked list
        while (curr != null) {
            if (deleteSet.contains(curr.val)) {
                // Skip the node by adjusting prev's next pointer
                prev.next = curr.next;
            } else {
                // Move prev only if we didn't delete the current node
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next; // Return the new head of the list
    }
}
