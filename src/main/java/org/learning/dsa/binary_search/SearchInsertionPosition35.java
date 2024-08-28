package org.learning.dsa.binary_search;

public class SearchInsertionPosition35 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        // At this point, l == r, so we need to decide if the target goes at index l or
        // after it.
        return nums[l] < target ? l + 1 : l;
    }
}
