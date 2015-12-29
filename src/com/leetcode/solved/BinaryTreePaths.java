package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> listPaths = new ArrayList<String>();
		if(root == null) return listPaths;
		binaryTreePaths(root,listPaths,new StringBuilder());
		return listPaths;
    }
	
	public void binaryTreePaths(TreeNode root, List<String> listString,StringBuilder path){
		
		if(root == null) return;
		if(root.left == null && root.right == null){
			path.append(root.val);
			listString.add(path.toString());
			path = new StringBuilder();
			return;
		}
		path.append(root.val + "->");
		StringBuilder rightPath = new StringBuilder(path); 
		binaryTreePaths(root.left, listString, path);
		binaryTreePaths(root.right, listString, rightPath);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
