package org.learning.dsa.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII630 {
    public static void main(String[] args) {

    }

    class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            });
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            int time = 0;
            for (int[] course : courses) {
                int duration = course[0];
                int lastDay = course[1];

                if (time + duration <= lastDay) {
                    time += duration;
                    pq.offer(duration);
                } else {
                    if (!pq.isEmpty()) {
                        int timeDurationRemoved = pq.peek();
                        if (timeDurationRemoved > duration) {
                            time -= timeDurationRemoved;
                            time += duration;
                            pq.poll();
                            pq.offer(duration);
                        }
                    }
                }
            }

            return pq.size();
        }
    }
}
