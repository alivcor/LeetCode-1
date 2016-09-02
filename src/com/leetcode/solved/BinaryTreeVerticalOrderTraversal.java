package com.leetcode.solved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Map<Integer,List<Integer>> mapCols = new TreeMap<>();
        
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        Queue<Integer> colQ = new LinkedList<Integer>();
        
        nodeQ.add(root);
        colQ.add(0);
        while(!nodeQ.isEmpty()){
            TreeNode topNode = nodeQ.poll();
            Integer col = colQ.poll();
            if(!mapCols.containsKey(col)) mapCols.put(col,new ArrayList<Integer>());
            mapCols.get(col).add(topNode.val);
            if(topNode.left != null){
                nodeQ.add(topNode.left);
                colQ.add(col-1);
            }
            if(topNode.right != null){
                nodeQ.add(topNode.right);
                colQ.add(col+1);
            }
        }
        
        for(Integer key : mapCols.keySet()) result.add(mapCols.get(key));
        return result;
    }
}
