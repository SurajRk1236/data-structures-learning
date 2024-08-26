package org.learning.dsa.by_hearts;

import org.learning.dsa.arrays.MajorityElementII229;
import org.learning.dsa.arrays.MajorityOfElement169;

import java.util.List;

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


public class BoyerMooreVotingAlgorithmExplanation169 {

    public static int majorityElement(int[] nums) {
        return MajorityOfElement169.majorityElement(nums);
    }

    public static List<Integer> majorityElement2(int[] nums) {
        return MajorityElementII229.majorityElement(nums);
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println("Majority Element: " + majorityElement(nums));
        // Output: 2
        System.out.println(majorityElement2(nums));
    }
}
