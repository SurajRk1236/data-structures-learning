package org.learning.dsa.binary_search;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(peak(new int[]{1,2,3,1}));
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
}
