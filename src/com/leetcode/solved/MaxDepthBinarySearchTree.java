package com.leetcode.solved;


public class MaxDepthBinarySearchTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right="
					+ right + "]";
		}
	      
	  };
	/*
	 * Maxdepth is the maximum distance from root to child node of a binary tree.
	 * In the function below:
	 * If root is null, the height of tree is Zero.
	 * Else height of tree is 1 + Maximum of Left or Right subtree's height. 
	 */
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
