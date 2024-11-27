package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorOfBinaryTree236 {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or matches p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recur for the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right return non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null result from left or right
        return (left != null) ? left : right;
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean exist = true;
        int ans = 1;
        while (exist) {
            int size = queue.size();

            boolean checkNewNodeExists = false;
            int nullCounter = 0;
            int maxSize = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.left != null || node.right != null) {
                        checkNewNodeExists = true;
                    }
                    queue.offer(root.left);
                    queue.offer(root.right);
                    maxSize += 1 + nullCounter;
                    nullCounter = 0;
                }else{
                    queue.offer(null);
                    queue.offer(null);
                    nullCounter++;
                }
            }
            ans = Math.max(ans, maxSize);
            exist = checkNewNodeExists;
        }

        return ans;
    }

}
