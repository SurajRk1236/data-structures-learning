package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversal987 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap to hold the column number (key) and a list of (row, value) pairs as value
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        // Perform a DFS traversal to populate the map with (column, row, value) tuples
        dfs(root, 0, 0, map);

        // Prepare the final result
        List<List<Integer>> result = new ArrayList<>();

        // Traverse the TreeMap columns in order (leftmost column to rightmost column)
        for (int column : map.keySet()) {
            // Get the list of (row, value) pairs for this column
            List<int[]> nodes = map.get(column);

            // Sort the list first by row, then by value if rows are the same
            Collections.sort(nodes, (a, b) -> {
                if (a[0] == b[0]) { // If rows are the same, sort by value
                    return a[1] - b[1];
                }
                return a[0] - b[0]; // Otherwise, sort by row
            });

            // Collect the sorted values for this column
            List<Integer> sortedColumn = new ArrayList<>();
            for (int[] node : nodes) {
                sortedColumn.add(node[1]);
            }
            result.add(sortedColumn);
        }

        return result;
    }

    // DFS helper method to traverse the tree and populate the map
    private void dfs(TreeNode node, int row, int col, TreeMap<Integer, List<int[]>> map) {
        if (node == null) {
            return;
        }

        // Add the node's value to the map at the appropriate column
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, node.val});

        // Recur for the left and right children
        dfs(node.left, row + 1, col - 1, map);  // Move left: decrease column, increase row
        dfs(node.right, row + 1, col + 1, map); // Move right: increase column, increase row
    }
}
