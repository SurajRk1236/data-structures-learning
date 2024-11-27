package org.learning.dsa.linked_list;

public class SwapNodesInLL1721 {
    public static void main(String[] args) {

    }

    public ListNode swapNodes(ListNode head, int k) {
        // Two pointers to find kth node from the start and end
        ListNode first = head, second = head, temp = head;

        // Move first pointer to the kth node
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Now, move temp pointer to the end and second pointer starts from the head
        while (temp != null) {
            temp = temp.next;
            if (k-- <= 0) {
                second = second.next;
            }
        }

        // Swap the values of the kth node from the beginning and the end
        int tempVal = first.val;
        first.val = second.val;
        second.val = tempVal;

        return head;
    }
}
