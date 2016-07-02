package com.leetcode.solved;


public class ValidateBinarySearchTree {
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
	public static boolean isValidBST(TreeNode root){
		return validateTree(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
	}
	
	public static boolean validateTree(TreeNode root, long minVal, long maxVal){
		if(root == null) return true;
		if(root.val > minVal && root.val < maxVal 
				 && validateTree(root.left, minVal, root.val)
				 && validateTree(root.right, root.val, maxVal) ) return true;
		return false;
	}

}
