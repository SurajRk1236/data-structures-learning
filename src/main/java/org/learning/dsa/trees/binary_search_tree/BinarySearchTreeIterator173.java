package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator173 {

    private Stack<TreeNode> data = new Stack<>();
    public BinarySearchTreeIterator173(TreeNode root) {
        pushAllLeftNodes(root);
    }

    public int next() {
        TreeNode leastData = data.pop();
        pushAllLeftNodes(leastData.right);
        return leastData.val;
    }

    public boolean hasNext() {
        return !data.isEmpty();
    }

    private void pushAllLeftNodes(TreeNode root){
        while(root != null){
            data.push(root);
            root = root.left;
        }
    }
}
