package com.leetcode.solved;


public class SymmetricTrees {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	};
	
	public static boolean isSymmetric(TreeNode root) {
	       if(root == null) return true;
	       return isSymUtil(root.left,root.right);
	    }

		public static boolean isSymUtil(TreeNode left, TreeNode right){
			if(left == null || right == null) 
				return (left == null && right == null);
			
			return (left.val == right.val && 
					isSymUtil(left.left, right.right) && isSymUtil(left.right, right.left));
			
		}
	public static void main(String[] args) {
		

	}

}
