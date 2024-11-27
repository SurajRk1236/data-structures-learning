package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderAndPreOrder105 {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inMap = new HashMap<>();

        // Populate the map with indices
        // of elements in the inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1, inMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
                               Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = inMap.get(preorder[preStart]);
        int numsLeft = index - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart,
                index - 1, inMap);

        root.right = buildTree(preorder, preStart + 1 + numsLeft, preEnd, inorder, index + 1,
                inEnd, inMap);

        return root;
    }
}
