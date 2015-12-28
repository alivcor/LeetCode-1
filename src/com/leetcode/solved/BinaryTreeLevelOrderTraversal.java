package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listTraversal = new ArrayList<List<Integer>>();
		levelOrderBottom(root,listTraversal,1);
        return listTraversal;
    }
    
    public void levelOrderBottom(TreeNode root,
			List<List<Integer>> listTraversal,int level) {
		if(root == null) return;
		if(listTraversal.size() < level){
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			listTraversal.add(list);
		}else{
		    listTraversal.get(level-1).add(root.val);
		}
		levelOrderBottom(root.left, listTraversal, level+1);
		levelOrderBottom(root.right, listTraversal, level+1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
