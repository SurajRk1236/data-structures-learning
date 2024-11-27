package org.learning.dsa.linked_list;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsNodesFromLL1171 {

    public static void main(String[] args) {

    }


    public ListNode removeZeroSumSublists(ListNode head) {
        // Dummy node to handle edge cases like removing head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // HashMap to store the cumulative sum and corresponding node
        Map<Integer, ListNode> sumMap = new HashMap<>();

        // Initialize prefix sum
        int prefixSum = 0;
        ListNode current = dummy;

        // First pass: calculate prefix sums and store in map
        while (current != null) {
            prefixSum += current.val;
            sumMap.put(prefixSum, current);
            current = current.next;
        }

        // Second pass: reset the pointers to remove zero-sum sublists
        prefixSum = 0;
        current = dummy;
        while (current != null) {
            prefixSum += current.val;

            // If the same prefix sum was seen before, skip nodes in between
            ListNode node = sumMap.get(prefixSum);
            if (node != current) {
                current.next = node.next; // Skip the zero-sum nodes
            }

            current = current.next;
        }

        return dummy.next; // Return the new head of the list
    }
}
