package com.leetcode.solved;

import com.leetcode.solved.BalancedBinaryTree.TreeNode;

public class InOrderSuccessorInBST {

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
	public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if(p.right != null){
            p = p.right;
            while(p.left != null) p = p.left;
            return p;
        }
        TreeNode potential = null;
        while(root != p){
            root = (p.val > root.val) ? root.right : (potential = root).left;
        }
        return potential;
    }
	
	public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(root.val <= p.val) return inorderSuccessor2(root.right,p);
        
        TreeNode leftInorderSuccSearch = inorderSuccessor2(root.left,p);
        return (leftInorderSuccSearch != null) ? leftInorderSuccSearch : root;
    }
	
	/*
    1. If right child exists, left most node in the right child.
    2. If current node is left child, parent else parent right.
    */
    TreeNode previous = null;
    TreeNode value = null;
    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        inOrder(root,p);
        return value;
    }
    
    private void inOrder(TreeNode root, TreeNode p){
        if(value != null || root == null) return;
        inOrder(root.left,p);
        if(p == previous) {
            value = root;
        }
        previous = root;
        inOrder(root.right,p);
    }
	
}
