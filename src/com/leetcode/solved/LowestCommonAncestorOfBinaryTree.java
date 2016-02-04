package com.leetcode.solved;


public class LowestCommonAncestorOfBinaryTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if(l == null) return r;
        if(r == null) return l;
        return root;
    }
}
