package org.learning.dsa.binary_search;

public class MedianSortedArrays4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0;
        int r = n1;

        while (l <= r) {
            int mid1 = (l + r) / 2;
            int mid2 = (n1 + n2 + 1) / 2 - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];

            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];
            if (l2 <= r1 && l1 <= r2) {
                if ((n1 + n2) % 2 == 0)
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                else
                    return Math.max(l1, l2);
            } else if (l1 > r2)
                r = mid1 - 1;
            else
                l = mid1 + 1;
        }
        return 0.0;
    }
}
