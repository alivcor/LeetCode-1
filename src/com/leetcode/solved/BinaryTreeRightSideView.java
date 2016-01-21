package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
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
	private int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Integer.max(height(root.left),height(root.right));
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        
        int array[] = new int[height(root)];
        rightSideView(root,array,0);
        
        for(int i = 0; i < array.length; i++){
            list.add(array[i]);
        }
        return list;
    }
    
    public void rightSideView(TreeNode root, int array[], int index) {
        
        if(root == null) return;
        if(array[index] == 0){
            array[index] = root.val;
        }
        
        rightSideView(root.right,array,index+1);
        rightSideView(root.left,array,index+1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
