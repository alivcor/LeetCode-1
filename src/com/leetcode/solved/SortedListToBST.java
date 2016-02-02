package com.leetcode.solved;


public class SortedListToBST {
	public static class ListNode{
		int val;
		ListNode next;
	}
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        
        return createTreeUtil(head, size);
    }
    
    public TreeNode createTreeUtil(ListNode head, int size){
        if(size == 0) return null;
        if(size == 1) return new TreeNode(head.val);
        int mid = size/2;
        ListNode curr = head;
        int count = 0;
        
        while(count < mid){
          curr = curr.next;
          count++;
        } 
        TreeNode root = new TreeNode(curr.val);
        root.left = createTreeUtil(head,mid);
        root.right = createTreeUtil(curr.next,size - mid - 1);
        
        return root;
    }

}
