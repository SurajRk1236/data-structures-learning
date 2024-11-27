package org.learning.dsa.linked_list;

public class DesignLinkedList707 {

        // Definition for a node in the linked list
        class Node {
            int val;
            Node next;

            // Constructor for a node
            public Node(int val) {
                this.val = val;
                this.next = null;
            }
        }

        // Head of the linked list
        private Node head;
        // Size of the linked list
        private int size;

        // Constructor to initialize the linked list
        public DesignLinkedList707() {
            head = null;
            size = 0;
        }

        // Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.val;
        }

        // Add a node of value val before the first element of the linked list.
        public void addAtHead(int val) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        // Append a node of value val as the last element of the linked list.
        public void addAtTail(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        // Add a node of value val before the index-th node in the linked list.
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            Node newNode = new Node(val);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }

        // Delete the index-th node in the linked list, if the index is valid.
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                head = head.next;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                current.next = current.next.next;
            }
            size--;
        }

        // Helper function to print the linked list (for debugging purposes)
        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        // Main method to test the implementation
        public static void main(String[] args) {
            DesignLinkedList707 linkedList = new DesignLinkedList707();
            linkedList.addAtHead(1);
            linkedList.addAtTail(3);
            linkedList.addAtIndex(1, 2); // linked list becomes 1 -> 2 -> 3
            linkedList.printList();
            System.out.println(linkedList.get(1)); // returns 2
            linkedList.deleteAtIndex(1); // now the linked list is 1 -> 3
            linkedList.printList();
            System.out.println(linkedList.get(1)); // returns 3
        }

}
