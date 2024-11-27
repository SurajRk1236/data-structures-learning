package org.learning.dsa.linked_list;

public class DeleteNodeByIndexBoss {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public Node deleteAtIndex(Node head, int index) {
        if (head == null || index < 0) {
            return head; // No deletion for an empty list or invalid index
        }

        // Create a dummy node to handle edge cases like deleting the head
        Node dummyNode = new Node(-1);
        dummyNode.next = head;
        Node current = dummyNode;

        // Move to the node just before the one we want to delete
        while (index > 0 && current.next != null) {
            current = current.next;
            index--;
        }

        // If we're not out of bounds, delete the node
        if (current.next != null) {
            current.next = current.next.next;
        }

        // Return the real head (dummyNode.next)
        return dummyNode.next;
    }
}
