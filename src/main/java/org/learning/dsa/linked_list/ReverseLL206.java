package org.learning.dsa.linked_list;

public class ReverseLL206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        // Initialize previous node to null (since new tail will point to null)
        ListNode prev = null;

        // Set current node to the head of the list
        ListNode curr = head;

        // Traverse the list until the current node becomes null (end of the list)
        while (curr != null) {
            // Temporarily store the next node
            ListNode nextTemp = curr.next;

            // Reverse the current node's pointer to point to the previous node
            curr.next = prev;

            // Move the previous node one step forward (to the current node)
            prev = curr;

            // Move the current node one step forward (to the next node in the original list)
            curr = nextTemp;
        }

        // After the loop, prev will be the new head of the reversed list
        return prev;
    }
}
