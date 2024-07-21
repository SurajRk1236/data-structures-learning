package org.learning.dsa.bit_manipulation;

public class CheckSingleInThreeSame {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 3, 1, 5, 5, 5, 9, 9,9};
        System.out.println(checkSingleInThreeSame(arr));
    }

    private static int checkSingleInThreeSame(int[] arr) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int bitwiseCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    bitwiseCount++;
                }
            }
            if (bitwiseCount % 3 == 1) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
