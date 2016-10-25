package com.leetcode.solved;


public class ID437_PathSumIII {
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}

	public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return sum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int sum(TreeNode root, int sum){
        if(root == null) return 0;
        int count = 0;
        if(sum == root.val) count += 1;
        return count + sum(root.left, sum - root.val) + 
                    sum(root.right, sum - root.val);
    }
}
