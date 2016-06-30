package com.leetcode.solved;

public class BinaryTreeMaximumPathSum {
	
	
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	private static class Result{
		int a;
		int b;
		public Result(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		
	}
    
	public static int maxPathSum(TreeNode root){
        Result result = maxPathSumUtil(root);
        return Integer.max(result.a, result.b);
    }
    public static Result maxPathSumUtil(TreeNode root){
    	if(root == null) return null;
		if(root.left == null && root.right == null) return new Result(root.val, root.val);
		
		int a = root.val;
		Result left = maxPathSumUtil(root.left);
		Result right =maxPathSumUtil(root.right);
		
		int currB = 0;
		int prevB = 0;
		if(left != null && right != null){
			a = Integer.max(a, a + Integer.max(left.a, right.a));
			currB = root.val + ((left.a > 0) ? left.a : 0) + ((right.a > 0) ? right.a : 0);
			prevB = Integer.max(left.b, right.b);
		}else if(root.left != null){
			a = Integer.max(a, a + left.a);
			currB = root.val + ((left.a > 0) ? left.a : 0);
			prevB = left.b;
		}else{
			a = Integer.max(a, a + right.a);
			currB = root.val + ((right.a > 0) ? right.a : 0);
			prevB = right.b;
		}
		
		return new Result(a,Integer.max(currB, prevB));
	}

}
