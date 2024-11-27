package org.learning.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTraingleII119 {
    public static void main(String[] args) {

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        row.add(1); // First element is always 1

        for (int i = 1; i <= rowIndex; i++) {
            row.add(1);  // Add a placeholder for the new element at the end
            // Update the row from the second-to-last to the first element (backwards)
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
}
