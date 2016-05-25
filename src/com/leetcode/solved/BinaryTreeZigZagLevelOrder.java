package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigZagLevelOrder {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return Collections.emptyList(); 
        List<List<Integer>> result = new ArrayList<>();
        levelOrderTraversal(root, result, 0);
        for(int i = 1; i < result.size(); i+=2){
        	Collections.reverse(result.get(i));
        }
        return result;
    }
	
	private static void levelOrderTraversal(TreeNode root, List<List<Integer>> list, int level){
		if(root == null) return;
		if(list.size() < level + 1) list.add(new ArrayList<>());
		list.get(level).add(root.val);
		levelOrderTraversal(root.left, list, level+1);
		levelOrderTraversal(root.right, list, level+1);
	}

}
