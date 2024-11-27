package org.learning.dsa.linked_list;

public class IntersectionOfTwoLL160 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        // Step 1: Get the length of both linked lists
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Step 2: Align the start of both lists
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Step 3: Traverse both lists simultaneously
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        // Step 4: Return the intersection node or null if there is no intersection
        return headA;
    }

    // Helper function to calculate the length of a linked list
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
