package org.learning.dsa.trees.binary_tree;

import org.learning.dsa.trees.TreeNode;

import java.util.List;


public class RootToNodePathGFG {
    public static void main(String[] args){

    }

    private boolean getPath(TreeNode treeNode, int val, List<Integer> temp){
        if (treeNode == null){
            return false;
        }
        temp.add(treeNode.val);
        if(treeNode.val == val){
           return true;
        }

        if(getPath(treeNode.left, val, temp) || getPath(treeNode.right, val, temp)){
            return true;
        }
        temp.remove(temp.size() - 1);
        return false;
    }
}
