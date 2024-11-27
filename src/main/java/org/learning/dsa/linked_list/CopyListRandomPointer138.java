package org.learning.dsa.linked_list;

public class CopyListRandomPointer138 {
    public static void main(String[] args) {

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Insert new nodes in between the original nodes
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val); // Create the copy node
            newNode.next = current.next;          // Link the copy node to the next original node
            current.next = newNode;               // Link original node to its copy
            current = newNode.next;               // Move to the next original node
        }

        // Step 2: Set the random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next; // Set the random of copy node
            }
            current = current.next.next;  // Move to the next original node
        }

        // Step 3: Restore the original list and extract the copied list
        current = head;
        Node newHead = head.next; // The head of the copied list
        Node copy = newHead;

        while (current != null) {
            current.next = current.next.next; // Restore the original list
            if (copy.next != null) {
                copy.next = copy.next.next; // Set the next pointer for the copied list
            }
            current = current.next;  // Move to the next original node
            copy = copy.next;        // Move to the next copy node
        }

        return newHead;  // Return the head of the deep copied list
    }
}
