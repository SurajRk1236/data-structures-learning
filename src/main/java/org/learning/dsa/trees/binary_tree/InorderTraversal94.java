package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal94 {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inorder(root.left, result);

        // Visit the root node
        result.add(root.val);

        // Traverse the right subtree
        inorder(root.right, result);
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true){
            if(node == null){
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }else {
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}
