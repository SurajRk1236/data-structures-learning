package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

public class ConstructBSTWithPreOrder1008 {
    public static void main(String[] args) {

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = new int[1];
        index[0] = 0;
        return bstFromPreorder(preorder, Integer.MAX_VALUE, index);
    }

    private TreeNode bstFromPreorder(int[] preorder, int bound, int[] index) {
        if (index[0] == preorder.length || preorder[index[0]] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = bstFromPreorder(preorder, root.val, index);
        root.right = bstFromPreorder(preorder, bound, index);
        return root;
    }
}
