package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElemBST {
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
	  
	  public static int kthSmallest(TreeNode root, int k) {
		  List<Integer> list = new ArrayList<Integer>();
		  kthSmallest(root, k, list);
		  if(list.size() < k) return -1;
		  return list.get(k-1);
	  }
	  /*
	   * Function would run an Inorder traversal,
	   * Storing each value in an ArrayList.
	   * As soon as we reach the kth element. Return.
	   */
	  public static void kthSmallest(TreeNode root, int k, List<Integer> list){
		  if(root == null) return;
		  kthSmallest(root.left, k,list);
		  list.add(root.val);
		  if(list.size() == k) return;
		  kthSmallest(root.right, k,list);
	  }
	  
}
