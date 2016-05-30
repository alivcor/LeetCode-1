package com.leetcode.solved;


public class CountCompleteTreeNodes {

	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			super();
			this.val = val;
		}
		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}
	}
	
	private static int heightL(TreeNode root){
		return (root == null) ? 0 : 1 + heightL(root.left);
	}
	public static int countNodes(TreeNode root) {
        if(root == null) return 0;
        int height = heightL(root);
        
        return ((height - heightL(root.right) == 1) ?  
        		countNodes(root.right) + (1<<(height-1)) : countNodes(root.left) + (1<<(height-2))); 
    }
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		System.out.println(countNodes(root));
	
		
	}
}
