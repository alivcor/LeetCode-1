package com.leetcode.solved;


public class InvertBinaryTree {
	
	public static class TreeNode{
		int val;
		TreeNode left, right, next;
	}
	/*
	 * Check if the root is null, return null. There is no tree.
	 * If the root is not null, for all the non-leaf nodes, 
	 * swap left and right children.
	 * 
	 * In the code, 
	 * We will invert left and right subtree. Once done,
	 * We will swap left and right pointer to the original tree. 
	 */
	public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        invertTree(root.left);
        invertTree(root.right);
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        return root;
    }

}
