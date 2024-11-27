package org.learning.dsa.linked_list;

public class MergeInBetweenLL1669 {
    public static void main(String[] args) {

    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = null, afterB = null;
        ListNode current = list1;
        int index = 0;

        // Traverse list1 to find the (a-1)-th and (b+1)-th nodes
        while (current != null) {
            if (index == a - 1) {
                prevA = current; // Node just before the a-th node
            }
            if (index == b + 1) {
                afterB = current; // Node just after the b-th node
                break;
            }
            current = current.next;
            index++;
        }

        // Connect the (a-1)-th node to the head of list2
        prevA.next = list2;

        // Find the tail of list2
        ListNode list2Tail = list2;
        while (list2Tail.next != null) {
            list2Tail = list2Tail.next;
        }

        // Connect the tail of list2 to the (b+1)-th node
        list2Tail.next = afterB;

        return list1;
    }
}
