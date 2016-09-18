package com.leetcode.solved;

public class CountUnivalueSubtree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	static int count = 0;
    public static int countUnivalSubtrees(TreeNode root) {
        count = 0;
        countSubtree(root);
        return count;
    }
    
    private static boolean countSubtree(TreeNode root){
        if(root == null) return true;
        
        boolean left = countSubtree(root.left);
        boolean right = countSubtree(root.right);
        
        if(!left || (root.left != null && root.left.val != root.val)) return false;
        if(!right || (root.right != null && root.right.val != root.val)) return false;
        
        count++;
        return true;
    }
}
