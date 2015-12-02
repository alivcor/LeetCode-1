package com.leetcode.solved;


public class InvertBinaryTree {
	
	public static class TreeNode{
		int val;
		TreeNode left, right, next;
	}
	public TreeNode invertTree(TreeNode root) {
        
		if(root == null) return null;
		if(root.left == null && root.right == null) return root;
		
		TreeNode temp = (root.left != null) ? root.left : null;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
    }

}
