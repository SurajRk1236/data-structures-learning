package org.learning.dsa.linked_list;

public class DeleteNodeInLL237 {
    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        if(node ==null || node.next == null){
            return;
        }

        // Copy the value from the next node to the current node
        node.val = node.next.val;

        // Skip the next node by pointing current node's 'next' to the next node's 'next'
        node.next = node.next.next;
    }
}
