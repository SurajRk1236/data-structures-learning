package org.learning.dsa.greedy;

public class LatestTimeByReplacingHiddenDigits1736 {

    public static void main(String[] args) {

    }

    class Solution {
        public String maximumTime(String time) {
            char[] timeArr = time.toCharArray();

            // Process the hour part
            if (timeArr[0] == '?') {
                timeArr[0] = (timeArr[1] == '?' || timeArr[1] <= '3') ? '2' : '1';
            }
            if (timeArr[1] == '?') {
                timeArr[1] = (timeArr[0] == '2') ? '3' : '9';
            }

            // Process the minute part
            if (timeArr[3] == '?') {
                timeArr[3] = '5';
            }
            if (timeArr[4] == '?') {
                timeArr[4] = '9';
            }

            return new String(timeArr);
        }
    }
}
