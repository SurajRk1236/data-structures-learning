package org.learning.dsa.linked_list;

public class DetectCycleWithPos142 {

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

    // Function to detect the start of the cycle in a linked list
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle possible in an empty or single-node list
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Cycle detection using two-pointer technique
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer one step
            fast = fast.next.next;    // Move fast pointer two steps

            // Cycle detected
            if (slow == fast) {
                // Initialize a pointer at head to find the cycle start
                ListNode start = head;

                // Move both pointers one step at a time
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start; // The node where they meet is the cycle start
            }
        }

        // No cycle found
        return null;
    }
}
