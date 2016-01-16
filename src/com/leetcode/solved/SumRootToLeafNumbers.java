package com.leetcode.solved;


public class SumRootToLeafNumbers {
	
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
	}
	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0, 0);
    }

	public int sumNumbers(TreeNode root, Integer sum, int currNumber){
		if(root == null) return currNumber;
		
		currNumber = 10*currNumber + root.val;
		if(root.left == null && root.right == null){
			sum += currNumber;
			return sum;
		}
		int result = 0;
		if(root.left != null)
		    result = sumNumbers(root.left,sum,currNumber);
		
		if(root.right != null)
		    result += sumNumbers(root.right,sum,currNumber);
	
	    return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
