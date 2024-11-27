package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

public class FindCielOfBSTGFG {
    public static void main(String[] args) {

    }

    public static int findCiel(TreeNode root, int target) {
        int ciel = -1;
        while (root != null) {
            if(root.val == target) {
                ciel = root.val;
                return ciel;
            }
            if (root.val < target){
                root = root.right;
            }else {
                ciel = root.val;
                root = root.left;
            }
        }
        return ciel;
    }
}
