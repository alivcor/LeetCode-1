package com.leetcode.solved;

public class FlattenBinTreeToLL {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
	public void flatten(TreeNode root) {
        flatTree(root);
    }
	
	private TreeNode flatTree(TreeNode root){
		if(root == null || (root.left == null && root.right == null)) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        left = flatTree(left);
        root.right = left;
        if(left != null ){
            while(left.right != null) left = left.right;
            left.right = flatTree(right);
        }else{
            root.right = flatTree(right);
        }   
        return root;
        
	}

}
