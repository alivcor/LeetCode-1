package com.leetcode.solved;

public class PathSum {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.val == sum && root.left == null && root.right == null) return true; 
		return (hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
