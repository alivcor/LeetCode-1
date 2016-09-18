package com.leetcode.solved;


public class LargestBSTSubtree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	class Result{
        int count;
        int min;
        int max;
        public Result(int count, int min, int max){
            this.count = count;
            this.min = min;
            this.max = max;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        Result result = BST(root);
        return Math.abs(result.count);
    }
    
    public Result BST(TreeNode root){
        if(root == null) return new Result(0,Integer.MAX_VALUE, Integer.MIN_VALUE);
        
        Result left = BST(root.left);
        Result right = BST(root.right);
        
        if(left.count < 0 || right.count < 0 || root.val < left.max || root.val > right.min) 
            return new Result(Math.max(Math.abs(left.count),Math.abs(right.count)) * -1, 0, 0);
        
        return new Result(left.count + right.count + 1, Math.min(left.min, root.val), Math.max(right.max, root.val));
    }

}
