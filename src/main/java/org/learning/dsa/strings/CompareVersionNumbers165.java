package org.learning.dsa.strings;

public class CompareVersionNumbers165 {
    public static void main(String[] args) {

    }


    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] levels1 = version1.split("\\.");
            String[] levels2 = version2.split("\\.");
            int maxLength = Math.max(levels1.length, levels2.length);

            // Compare each level
            for (int i = 0; i < maxLength; i++) {
                int v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0; // Default to 0 if out of bounds
                int v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0; // Default to 0 if out of bounds

                if (v1 != v2) {
                    return v1 < v2 ? -1 : 1; // Return comparison result
                }
            }

            // If all levels are equal
            return 0;
        }
    }
}
