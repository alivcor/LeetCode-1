package com.leetcode.solved;


public class ClosestBinarySearchTreeValue {
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

	public int closestValue(TreeNode root, double target) {
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return root.val;
        
        double rootDif = Math.abs(target - (double)root.val);
        int other = root.val;
        if(root.val - target > 0 && root.left != null) other = closestValue(root.left,target);
        else if(root.val - target < 0 && root.right != null) other = closestValue(root.right,target);
        
        return (rootDif < Math.abs(target - (double)other)) ? root.val : other;
    }
    

}
