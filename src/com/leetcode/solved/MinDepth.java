package com.leetcode.solved;


public class MinDepth {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	public int minDepth(TreeNode root) {
	    if(root == null) return 0;
	    if(root.left == null && root.right == null) return 1;
	    return 1 + Integer.min(minDepthUtil(root.left),minDepthUtil(root.right));
    }
	
	private int minDepthUtil(TreeNode root){
		if(root == null) return Integer.MAX_VALUE - 1;
		if(root.left == null && root.right == null) return 1;
		return 1 + Integer.min(minDepthUtil(root.left),minDepthUtil(root.right));
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
