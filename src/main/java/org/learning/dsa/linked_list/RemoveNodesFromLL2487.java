package org.learning.dsa.linked_list;

public class RemoveNodesFromLL2487 {

    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;

        // Step 1: Reverse the linked list
        ListNode reversedHead = reverseList(head);

        // Step 2: Traverse the reversed list and keep the maximum values
        ListNode curr = reversedHead;
        ListNode maxNode = reversedHead;  // Keep track of the maximum node
        ListNode prev = null;

        while (curr != null) {
            if (curr.val >= maxNode.val) {
                // Update maxNode to the current node as it has a higher or equal value
                maxNode = curr;
                prev = curr;  // Keep the previous node for linking
            } else {
                // Remove the current node by linking prev's next to curr's next
                prev.next = curr.next;
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
