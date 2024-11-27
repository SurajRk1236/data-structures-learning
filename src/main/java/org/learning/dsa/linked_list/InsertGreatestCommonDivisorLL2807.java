package org.learning.dsa.linked_list;

public class InsertGreatestCommonDivisorLL2807 {
    public static void main(String[] args) {

    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;

        while (current != null && current.next != null) {
            int gcdValue = gcd(current.val, current.next.val); // Calculate GCD
            ListNode gcdNode = new ListNode(gcdValue);         // Create new node with GCD

            // Insert the GCD node between current and current.next
            gcdNode.next = current.next;
            current.next = gcdNode;

            // Move to the next original node (skip the inserted GCD node)
            current = gcdNode.next;
        }

        return head;
    }

    // Helper function to calculate GCD
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
