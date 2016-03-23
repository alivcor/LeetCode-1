package com.leetcode.solved;


public class HouseRobberIII {
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
	  
	  public int rob(TreeNode root) {
		  if(root == null) return 0;
		  if(root.left == null && root.right == null) return root.val;
		  
		  int childSum = rob(root.left) + rob(root.right);
		  int grandC = 0;
		  if(root.left != null) grandC += rob(root.left.left) + rob(root.left.right);
		  if(root.right != null) grandC += rob(root.right.left) + rob(root.right.right);
		  
		  return Integer.max(root.val + grandC, childSum);
    }
	  
	  
	  


}
