package org.learning.dsa.linked_list.dll;

import java.util.*;

public class LRUCache146 {
    public static void main(String[] args) {

    }

    class LRUCache {
        private class Node {
            int key, value;
            Node prev, next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final Map<Integer, Node> cache;
        private final Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.head = new Node(-1, -1); // Dummy head
            this.tail = new Node(-1, -1); // Dummy tail
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            Node node = cache.get(key);
            moveToHead(node); // Mark as recently used
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node); // Mark as recently used
            } else {
                if (cache.size() == capacity) {
                    removeTail(); // Remove least recently used
                }
                Node newNode = new Node(key, value);
                addToHead(newNode); // Add new node to the front
                cache.put(key, newNode);
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void removeTail() {
            Node lru = tail.prev;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }

}
