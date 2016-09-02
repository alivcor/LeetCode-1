package com.leetcode.solved;


public class BinaryTreeLongestConsecutiveSequence {

	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return longestConsecutive(root,root.val,0);
        
    }
    public int longestConsecutive(TreeNode root, int desiredVal, int curCount) {
        if(root == null) return 0;
        
        int result = 0;
        if(root.val == desiredVal){
            curCount += 1;
            result = curCount;
        }else curCount = 1;
        
        result = Integer.max(result,
            Integer.max(longestConsecutive(root.left,root.val+1,curCount),
                longestConsecutive(root.right,root.val+1,curCount)));
        
        return result;
    }
}
