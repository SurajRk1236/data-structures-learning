package org.learning.dsa.linked_list.dll;

public class FlattenMultilevelDLL430 {

    public static void main(String[] args) {

    }
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        // Call the helper function to flatten the list starting from the head
        flattenHelper(head);
        return head;
    }

    // Helper function to flatten the list starting from node 'curr'
    // Returns the tail of the flattened list
    private Node flattenHelper(Node curr) {
        Node tail = curr; // This will keep track of the last node in the flattened list
        while (curr != null) {
            Node next = curr.next; // Save the next pointer since we may overwrite it

            // If the current node has a child, we need to flatten the child list
            if (curr.child != null) {
                // Recursively flatten the child list
                Node childTail = flattenHelper(curr.child);

                // Insert the flattened child list between curr and next
                curr.next = curr.child;
                curr.child.prev = curr;

                // If there was a next node, reconnect it after the childTail
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // Clear the child pointer
                curr.child = null;

                // Update the tail to be the tail of the child list
                tail = childTail;
            } else {
                // If no child, move the tail to the current node
                tail = curr;
            }

            // Move to the next node (which could be null if we've processed a child)
            curr = next;
        }
        return tail; // Return the last node (tail) of the flattened list
    }
}
