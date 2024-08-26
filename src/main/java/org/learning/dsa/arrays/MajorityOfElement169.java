package org.learning.dsa.arrays;


/**
 * Approach:
 * The most common and efficient approach to solving this problem is the Boyer-Moore Voting Algorithm. This algorithm works in O(n) time with O(1) space complexity.
 *
 * Boyer-Moore Voting Algorithm Explanation:
 * Initialize a candidate: Start by assuming the first element is the majority element (candidate).
 * Count votes: Traverse the array. Each time you encounter the candidate, increase the count. If you encounter a different element, decrease the count.
 * Switch candidate: If the count drops to zero, switch the candidate to the current element and reset the count.
 * Final candidate: By the end of the array, the candidate will be the majority element.
 */

public class MajorityOfElement169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,3}));
    }

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }

        return candidate;
    }
}
