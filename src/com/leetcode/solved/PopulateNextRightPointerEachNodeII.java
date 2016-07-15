package com.leetcode.solved;

public class PopulateNextRightPointerEachNodeII {
	public class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
	}
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        while(root != null){
        	TreeLinkNode temp = new TreeLinkNode(0);
        	TreeLinkNode curNode = temp;
        	while(root != null){
        		if(root.left != null){ curNode.next = root.left; curNode = curNode.next;}
        		if(root.right != null){ curNode.next = root.right; curNode = curNode.next;}
        		root = root.next;
        	}
        	root = temp.next;
        }
        
    }
}
