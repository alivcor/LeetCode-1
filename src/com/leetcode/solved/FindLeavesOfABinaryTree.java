package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfABinaryTree {
	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findLeaves(root,result);
        return result;
    }
        
    private int findLeaves(TreeNode root, List<List<Integer>> list){
        if(root == null) return -1;
        int index = Integer.max(findLeaves(root.left,list),findLeaves(root.right,list)) + 1;
        if(list.size() == index) list.add(new ArrayList<Integer>());
        list.get(index).add(root.val);
        return index;
    }
}
