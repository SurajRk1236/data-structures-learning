package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BottomViewBinaryTreeGFG {
    public static void main(String[] args) {
        
    }

    class Pair {
        int val;
        TreeNode node;
        Pair(TreeNode node, int val) {
            this.val = val;
            this.node = node;
        }
    }

    public List<Integer> bottomView(TreeNode root) {
        Map<Integer, TreeNode> map = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return null;
        }
        Pair topView = new Pair(root, 0);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(topView);
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            map.put(current.val, current.node);
            if (current.node.left != null) {
                queue.offer(new Pair(current.node.left, current.val - 1));
            } else if (current.node.right != null) {
                queue.offer(new Pair(current.node.right, current.val + 1));
            }
        }
        for (int data : map.keySet()){
            result.add(map.get(data).val);
        }
        return result;
    }
}
