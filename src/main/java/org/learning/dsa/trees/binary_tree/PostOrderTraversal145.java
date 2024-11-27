package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal145 {
    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(TreeNode root,List<Integer> result){
        if(root == null)
            return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            stack2.push(node);
            if(node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }

        while(!stack2.isEmpty()){
            result.add(stack2.pop().val);
        }
        return result;
    }
}
