package org.learning.dsa.linked_list;

public class DetectACycle141 {
    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle possible in an empty or single-node list
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer one step
            fast = fast.next.next;    // Move fast pointer two steps

            // If slow and fast meet, a cycle is detected
            if (slow == fast) {
                return true;
            }
        }

        // No cycle detected
        return false;
    }
}
