package org.learning.dsa.heaps;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringFromKLists632 {
    public static void main(String[] args) {

    }

    class Solution {
        class Element {
            int value;
            int listIdx;
            int index;

            Element(int value, int listIdx, int index) {
                this.value = value;
                this.listIdx = listIdx;
                this.index = index;
            }
        }

        public int[] smallestRange(List<List<Integer>> nums) {
            PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
            int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.size(); i++) {
                int value = nums.get(i).get(0);
                pq.offer(new Element(value, i, 0));
                max = Math.max(max, value);
            }

            while (pq.size() == nums.size()) {
                Element ele = pq.poll();
                if ((max - ele.value) < (rangeEnd - rangeStart)) {
                    rangeEnd = max;
                    rangeStart = ele.value;
                }
                if (nums.get(ele.listIdx).size() > ele.index + 1) {
                    int newValue = nums.get(ele.listIdx).get(ele.index + 1);
                    pq.offer(new Element(newValue, ele.listIdx, ele.index + 1));
                    max = Math.max(max, newValue);
                } else {
                    break;
                }
            }

            return new int[] { rangeStart, rangeEnd };
        }
    }
}
