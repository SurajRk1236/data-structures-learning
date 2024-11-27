package org.learning.dsa.trees.binary_search_tree;

import org.learning.dsa.trees.TreeNode;

public class DeleteNodeInBST450 {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val == key){
            return findLeftTreeNode(root);
        }
        TreeNode curr = root;

        while(curr != null){
            if(curr.val >= key){
                if(curr.left != null && curr.left.val == key){
                    curr.left = findLeftTreeNode(curr.left);
                    break;
                }else{
                    curr = curr.left;
                }
            }else{
                if(curr.right != null && curr.right.val == key){
                    curr.right = findLeftTreeNode(curr.right);
                    break;
                }else{
                    curr = curr.right;
                }
            }
        }
        return root;
    }

    private TreeNode findLeftTreeNode(TreeNode node){
        if (node.left == null) {
            return node.right;
        } else if (node.right == null){
            return node.left;
        } else{
            TreeNode maxDepthNode = findMaxDepthNode(node.left);
            maxDepthNode.right = node.right;
            return node.left;
        }
    }

    private TreeNode findMaxDepthNode(TreeNode node){
        if(node.right == null){
            return node;
        }
        return findMaxDepthNode(node.right);
    }
}
