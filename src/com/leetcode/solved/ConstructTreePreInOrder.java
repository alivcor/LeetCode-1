package com.leetcode.solved;

public class ConstructTreePreInOrder {
	
	public static class TreeNode{
		public TreeNode(int i) {
			this.val = i;
		}
		int val;
		TreeNode left;
		TreeNode right;
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,inorder.length-1,0);
    }

	private static int findIndex(int[] array, int val, int start, int end){
		for(int i = start; i <= end; i ++){
			if(array[i] == val) return i;
		}
		return -1;
	}
	private static  TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd,
			int preStart) {
		
		if(inStart > inEnd) return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		if(inStart == inEnd){
			return root;
		}
		
		int index = findIndex(inorder, preorder[preStart], inStart, inEnd);
		if(index != inStart) root.left = buildTree(preorder, inorder, inStart, index-1, preStart + 1);
		if(index != inEnd) root.right = buildTree(preorder, inorder, index+1, inEnd, preStart + 1+ (index - inStart));
	
		return root;
	}
	
	public static void main(String[] args){
		int in[] = {2,1};
		int pr[] = {1,2};
		
		TreeNode root = buildTree(pr, in);
		System.out.println(root);
	}
}
