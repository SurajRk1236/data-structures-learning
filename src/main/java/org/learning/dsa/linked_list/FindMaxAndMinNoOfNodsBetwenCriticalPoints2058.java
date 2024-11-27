package org.learning.dsa.linked_list;

public class FindMaxAndMinNoOfNodsBetwenCriticalPoints2058 {
    public static void main(String[] args) {

    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            // If there are less than 3 nodes, there can't be any critical points
            return new int[] { -1, -1 };
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        int firstCP = -1, lastCP = -1, minDistance = Integer.MAX_VALUE;
        int index = 1; // Start from the second node as curr is head.next
        int prevCP = -1; // Store the index of the previous critical point

        while (next != null) {
            // A critical point occurs if curr is greater or smaller than both prev and next
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                if (firstCP == -1) {
                    // This is the first critical point
                    firstCP = index;
                } else {
                    // This is not the first critical point, calculate the min distance
                    minDistance = Math.min(minDistance, index - prevCP);
                }
                // Always update lastCP and prevCP
                lastCP = index;
                prevCP = index;
            }
            // Move to the next set of nodes
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }

        // If we have less than two critical points, return [-1, -1]
        if (firstCP == -1 || lastCP == firstCP) {
            return new int[] { -1, -1 };
        }

        // Max distance is the distance between the first and last critical points
        int maxDistance = lastCP - firstCP;

        return new int[] { minDistance, maxDistance };
    }
}
