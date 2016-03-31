package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII {
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
	public List<TreeNode> generateTrees(int n) {
		if(n == 0) return Collections.EMPTY_LIST;
		return generateTrees(1, n);
    }
	
	public List<TreeNode> mergeNodes(List<TreeNode> left, List<TreeNode> right, TreeNode root){
		List<TreeNode> resultList = new ArrayList<>();
		for(TreeNode leftNode : left){
			for(TreeNode rightNode : right){
				TreeNode temp = new TreeNode(root.val);
				temp.left = leftNode;
				temp.right = rightNode;
				resultList.add(temp);
			}
		}
		
		return resultList;
	}
	public List<TreeNode> generateTrees(int start, int end){
		List<TreeNode> list = new ArrayList<>();
		if(start > end) {
			list.add(null);
			return list;
		}
		if(start == end){
			list.add(new TreeNode(start));
			return list;
		}
		
		for(int i = start; i <= end; i++){
			TreeNode root = new TreeNode(i);
			List<TreeNode> left = generateTrees(start,i-1);
			List<TreeNode> right = generateTrees(i+1,end);
			list.addAll(mergeNodes(left, right, root));
		}
		
		return list;
	}

}
