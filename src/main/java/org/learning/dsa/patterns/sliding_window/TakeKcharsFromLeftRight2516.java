package org.learning.dsa.patterns.sliding_window;

public class TakeKcharsFromLeftRight2516 {
    public static void main(String[] args) {

    }

    class Solution {
        public int takeCharacters(String s, int k) {
            if (k == 0)
                return 0;

            int n = s.length();
            int[] count = new int[3]; // Count 'a', 'b', 'c'

            // Count all characters in the string
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // If any character count is less than k, return -1
            if (count[0] < k || count[1] < k || count[2] < k) {
                return -1;
            }

            // Sliding window logic
            int[] currentCount = new int[3];
            int maxMiddle = 0;
            int left = 0;

            for (int right = 0; right < n; right++) {
                currentCount[s.charAt(right) - 'a']++;

                // Ensure the window is valid
                while ((count[0] - currentCount[0] < k) ||
                        (count[1] - currentCount[1] < k) ||
                        (count[2] - currentCount[2] < k)) {
                    currentCount[s.charAt(left) - 'a']--;
                    left++;
                }

                // Update the maximum valid middle window
                maxMiddle = Math.max(maxMiddle, right - left + 1);
            }

            return n - maxMiddle;
        }
    }
}
