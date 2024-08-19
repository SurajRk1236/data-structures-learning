package org.learning.dsa.arrays;

public class FindMissingNumber41 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositivev2(new int[]{3, 4, -1, 1}));
    }

    public static int firstMissingPositivev2(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int currentIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[currentIndex]) {
                swap(nums, i, currentIndex);
            } else
                i++;
        }
        for (int j = 0; j < n - 1; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return n + 1;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            if (num != 0) {
                min = Math.min(min, num);
                max = Math.max(max, num);
                sum += num;
            }
        }
        int nTerm = (max - min) + 1;
        int requiredSum = (nTerm / 2) * (2 * min + (nTerm - 1));
        int requiredAns = requiredSum - sum;

        return requiredAns == 0 ? max + 1 : requiredAns;
    }
}
