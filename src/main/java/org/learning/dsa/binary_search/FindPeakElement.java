package org.learning.dsa.binary_search;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(peak(new int[]{1,2,3,1}));
        System.out.println(findMin(new int[]{1,2,3,1}));
    }
    private static int peak(int[] input){
        int left = 0;
        int right = input.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(input[mid] < input[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return input[left];
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost element, min must be on the
            // right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, min could be the mid element or to the left of mid
                right = mid;
            }
        }

        // After the loop ends, left will point to the minimum element
        return left == 0 ? nums[nums.length - 1] : nums[left - 1];
    }
}
