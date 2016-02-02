package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSum2 {

	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        if(root == null) return Collections.emptyList();
	        if(root.left == null && root.right == null){
	            if(sum == root.val) {
	                List<Integer> list = new ArrayList();
	                list.add(root.val);
	                List<List<Integer>> lol = new ArrayList();
	                lol.add(list);
	                return lol;
	            }
	            return Collections.emptyList();
	        }
	        List<List<Integer>> left = pathSum(root.left, sum - root.val);
	        List<List<Integer>> right = pathSum(root.right, sum - root.val);
	        
	        for(List<Integer> list : left)
	            list.add(0,root.val);
	        for(List<Integer> list : right)
	            list.add(0,root.val);
	            
	        if(left.size() == 0) return right;
	        if(right.size() == 0) return left;
	        left.addAll(right);
	        
	        return left;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
