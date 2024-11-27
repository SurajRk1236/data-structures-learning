package org.learning.dsa.linked_list;

public class ReverseLLII92 {

    public static void main(String[] args) {

    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Base case: if the list is empty or left == right, no need to reverse anything
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify edge cases (e.g., when left == 1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Traverse to the node just before the `left` position
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Start reversing the sublist
        ListNode current = prev.next;  // The node at the `left` position
        ListNode next = null;
        ListNode reversePrev = null;

        for (int i = left; i <= right; i++) {
            next = current.next;
            current.next = reversePrev;
            reversePrev = current;
            current = next;
        }

        // Step 3: Reconnect the reversed part with the rest of the list
        prev.next.next = current;   // Connect the node at the end of the reversed sublist to `right + 1`
        prev.next = reversePrev;    // Connect the node before `left` to the new head of the reversed sublist

        return dummy.next;
    }
}
