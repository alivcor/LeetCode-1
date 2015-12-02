package com.leetcode.solved;

public class ReverseLinkList {
	 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	
    public ListNode reverseList(ListNode head) {
    
    	if(head == null || head.next == null) return head;
    	
    	ListNode rest = head.next;
    	ListNode revRest = reverseList(rest);
    	rest.next = head;
    	head.next = null;
    	
    	return revRest;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
