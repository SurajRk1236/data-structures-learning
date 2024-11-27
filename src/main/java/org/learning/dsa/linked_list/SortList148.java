package org.learning.dsa.linked_list;

public class SortList148 {
    public static void main(String[] args) {

    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: empty list or single node
        }

        // Find the middle of the list
        ListNode mid = getMid(head);

        // Split the list into two halves
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Break the list into two halves

        // Recursively sort each half
        left = sortList(left);
        right = sortList(right);

        // Merge the two sorted halves
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null; // To disconnect the left half
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev; // Return the node before the middle
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // Dummy node for easy merging
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append remaining nodes from either list
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
    }
}
