package com.leetcode.tried;

public class BalancedBinaryTree {
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

	  public static int[] isBal(TreeNode root){
			if(root == null)  return new int[]{1,0}; 
			if((root.left == null && root.right == null)) return new int[]{1,1};
			
			int[] LArray = isBal(root.left);
			int[] RArray = isBal(root.right);
			
			if(LArray[0] == 0 || RArray[0] == 0){
				return new int[]{0,1};
			}
			
			if(Integer.max(LArray[1],RArray[1]) - Integer.min(LArray[1],RArray[1]) <= 1)
				return new int[]{1,Integer.max(LArray[1], RArray[1]) + 1};
			
			return new int[]{0,0};
		}
		
	public static boolean isBalanced(TreeNode root) {
		int[] arr =  isBal(root); 
	    return (arr[0] == 0) ? false : true;
	}
	  
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		
		System.out.println(isBalanced(root));

	}

}
