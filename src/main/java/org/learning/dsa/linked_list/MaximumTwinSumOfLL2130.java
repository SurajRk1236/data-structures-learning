package org.learning.dsa.linked_list;

public class MaximumTwinSumOfLL2130 {
    public static void main(String[] args) {

    }

    public int pairSum(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }

        // Step 1: Find the middle of the linked list using slow and fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow);

        // Step 3: Calculate the maximum twin sum
        ListNode firstHalf = head;
        int maxTwinSum = 0;
        while (secondHalf != null) {
            maxTwinSum = Math.max(maxTwinSum, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 4 (optional): Reverse the second half again to restore the original list
        // slow.next = reverseList(slow.next);

        return maxTwinSum;
    }

    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
