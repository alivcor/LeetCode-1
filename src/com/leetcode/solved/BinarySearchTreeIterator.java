package com.leetcode.solved;

import java.util.Stack;


public class BinarySearchTreeIterator {
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
	  
	  	Stack<TreeNode> stack;
	    public BinarySearchTreeIterator(TreeNode root) {
	        stack = new Stack();
	        while(root != null){
	        	stack.add(root);
	        	root = root.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return (stack.isEmpty()) ? false : true;
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode top = stack.pop();
	        if(top.right != null){
	        	TreeNode right = top.right;
	        	while(right != null){
	        		stack.add(right);
	        		right = right.left;
	        	}
	        }
	        return top.val;
	    }
}
