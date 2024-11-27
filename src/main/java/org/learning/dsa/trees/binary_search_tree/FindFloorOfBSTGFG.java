package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

public class FindFloorOfBSTGFG {
    public static void main(String[] args) {

    }

    public int findFloor(TreeNode root, int val) {
        int ans = -1;
        while (root != null) {
            if (root.val == val) {
                ans = root.val;
                return ans;
            }

            if (root.val > val) {
                root = root.left;
            } else {
                ans = root.val;
                root = root.right;
            }
        }
        return ans;
    }
}
