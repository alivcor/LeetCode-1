package com.leetcode.tried;

public class BalancedBinaryTree {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  };

	  public boolean isBalanced(TreeNode root) {
	     if(root == null || (root.left == null && root.right == null)) return true;
	     if(root.left == null || root.right == null) return false;
	     
	     return (isBalanced(root.left) && isBalanced(root.right)); 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
