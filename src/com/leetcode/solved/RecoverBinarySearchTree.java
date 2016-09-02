package com.leetcode.solved;


public class RecoverBinarySearchTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode elem1,elem2;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        Integer val = elem1.val;
        elem1.val = elem2.val;
        elem2.val = val;
    }
    
    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(elem1 == null && prev.val >= root.val){
            //this is the larger element placed at a position of smaller one, so prev is the elem1
            elem1 = prev;
        }
        if(elem1 != null && prev.val >= root.val){
            //this is a smaller element placed in the position of larger one, so root is the elem2
            elem2 = root;
        }
        prev = root;
        inOrder(root.right);
    }
}
