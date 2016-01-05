package com.leetcode.solved;

public class SameTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	};
	/*
	 * Check if two given trees are same or not.
	 * Base condition: If one of the trees are null, then
	 * both trees are only same if other is null, else they are different.
	 * 
	 *  If both the trees are not null, they are same only if:
	 *  1. The root data for both of them are same.
	 *  2. The Left subtree for both trees are same.
	 *  3. The right subtree for both trees are same.
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return (p == null && q == null);
        return (p.val == q.val 
        		&& isSameTree(p.left,q.left)
        		&& isSameTree(p.right,q.right));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
