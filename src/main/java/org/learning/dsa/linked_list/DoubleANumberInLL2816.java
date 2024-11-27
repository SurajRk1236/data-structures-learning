package org.learning.dsa.linked_list;

public class DoubleANumberInLL2816 {
    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode doubleIt(ListNode head) {
        if (head == null) {
            return null;
        }

        // Step 1: Reverse the linked list
        ListNode reversedHead = reverseList(head);

        // Step 2: Double the number and handle the carry
        ListNode curr = reversedHead;
        int carry = 0;

        while (curr != null) {
            int doubledValue = curr.val * 2 + carry; // Double the value and add the carry
            curr.val = doubledValue % 10;           // Update the node with the new digit
            carry = doubledValue / 10;              // Update carry for the next node

            // If there's no next node but we still have a carry, add a new node
            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                carry = 0; // Reset carry after adding the last node
            }

            curr = curr.next;
        }

        // Step 3: Reverse the list back to its original order
        return reverseList(reversedHead);
    }

    // Helper function to reverse the linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
