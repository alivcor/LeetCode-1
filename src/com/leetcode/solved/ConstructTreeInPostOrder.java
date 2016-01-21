package com.leetcode.solved;

public class ConstructTreeInPostOrder {
	
	public static class TreeNode{
		public TreeNode(int i) {
			this.val = i;
		}
		int val;
		TreeNode left;
		TreeNode right;
	}

	 public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if(inorder == null || inorder.length == 0) return null;
	        return buildTree(inorder,postorder,0,inorder.length-1,postorder.length-1);
	    }
	    
	    private int findIndex(int[] inorder, int start, int end, int val){
	        for(int i = start; i <= end; i++){
	            if(inorder[i] == val) return i;
	        }
	        return -1;
	    }
	    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd){
	        if(inStart > inEnd) return null;
	        
	        TreeNode root = new TreeNode(postorder[postEnd]);
	        if(inStart == inEnd) return root;
	        
	        int index = findIndex(inorder,inStart,inEnd,postorder[postEnd]);
	        if(index != inStart) root.left = buildTree(inorder,postorder,inStart,index-1,postEnd-1 - (inEnd - index));
	        if(index != inEnd) root.right = buildTree(inorder,postorder,index+1,inEnd, postEnd - 1);
	        
	        return root;
	    }

	
}
