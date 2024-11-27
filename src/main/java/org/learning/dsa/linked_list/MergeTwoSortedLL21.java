package org.learning.dsa.linked_list;

public class MergeTwoSortedLL21 {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1); // Dummy node to start the merged list
        ListNode currentNode = dummyNode; // Pointer to the current node in the merged list

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next; // Move the pointer to the next node
        }

        // Attach the remaining nodes from either list (if any)
        if (list1 != null) {
            currentNode.next = list1;
        } else {
            currentNode.next = list2;
        }

        return dummyNode.next; // Skip the dummy node and return the merged list
    }
}
