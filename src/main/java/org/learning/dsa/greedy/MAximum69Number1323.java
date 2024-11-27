package org.learning.dsa.greedy;

public class MAximum69Number1323 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maximum69Number (int num) {
            // Convert the number to a mutable StringBuilder
            StringBuilder nums = new StringBuilder(String.valueOf(num));

            // Find the first occurrence of '6' and replace it with '9'
            for (int i = 0; i < nums.length(); i++) {
                if (nums.charAt(i) == '6') {
                    nums.setCharAt(i, '9');
                    break;  // Stop after the first change
                }
            }

            // Convert the modified StringBuilder back to an integer
            return Integer.parseInt(nums.toString());
        }
    }
}
