package org.learning.dsa.linked_list;

public class ReorderList143 {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;  // Disconnect the first half from the second

        // Step 3: Merge the two halves
        ListNode firstHalf = head;
        mergeLists(firstHalf, secondHalf);
    }

    // Helper function to reverse the linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // Helper function to merge two lists in an alternating fashion
    private void mergeLists(ListNode first, ListNode second) {
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}