package com.leetcode.solved;

public class LowestCommonAncestorBST {

	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	};
	/*
	 * Lowest Common Ancestor is the root of the smallest subtree containing both nodes.
	 * The code works like:
	 * If root is null: No common ancestor exists. Return Null
	 * If One of the nodes is root(this will also work when is the parent of other): return Root
	 * If both lie on the same side of the root, call recursive function on left or right subtree.
	 * If both lie on different side of root, return root.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //If Root is null or one of the nodes.
        if(root == null || root == p || root == q) return root;
        //If Root is greater than equal to both. Both would exist in left.
        if (root.val >= p.val && root.val >= q.val)
            return lowestCommonAncestor(root.left,p,q);
        
        //If Root less than both.
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
           
        return root;
    }
}
