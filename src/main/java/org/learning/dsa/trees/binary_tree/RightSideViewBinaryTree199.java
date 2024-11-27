package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewBinaryTree199 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveBinaryCall(root, result, 0);
        return result;
    }

    private void recursiveBinaryCall( TreeNode root, List<Integer> result, int depth){
        if(root == null){
            return;
        }
        if(result.size() == depth){
            result.add(root.val);
        }
        recursiveBinaryCall(root.right, result, depth + 1);
        recursiveBinaryCall(root.left, result, depth + 1);
    }
}
