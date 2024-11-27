package org.learning.dsa.linked_list;

public class PallindromeLL234 {
    public static void main(String[] args) {

    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // A single node or empty list is a palindrome
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalfHead = reverseList(slow);

        // Step 3: Compare the two halves
        ListNode firstHalfHead = head;
        ListNode secondHalfIter = secondHalfHead;
        boolean isPalindrome = true;
        while (secondHalfIter != null) {
            if (firstHalfHead.val != secondHalfIter.val) {
                isPalindrome = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfIter = secondHalfIter.next;
        }

        // Optional: Restore the second half of the list (reverse it back)
        reverseList(secondHalfHead);

        return isPalindrome;
    }

    // Helper function to reverse a linked list
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
}
