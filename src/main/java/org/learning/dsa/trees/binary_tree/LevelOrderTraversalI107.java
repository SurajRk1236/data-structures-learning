package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversalI107 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        Stack<List<Integer>> finalResult = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> tempAnswer = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i< size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                tempAnswer.add(root.val);
            }
            finalResult.push(tempAnswer);
        }
        while(!finalResult.isEmpty()){
            result.add(finalResult.pop());
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>(); // Use LinkedList to easily add to the beginning
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level-order traversal
        while (!queue.isEmpty()) {
            List<Integer> tempAnswer = new ArrayList<>();
            int size = queue.size();

            // Iterate over nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tempAnswer.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            // Add the current level at the start of the result list
            result.add(0, tempAnswer); // Adds at the beginning for bottom-up order
        }

        return result;
    }
}
