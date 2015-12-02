package com.leetcode.solved;

public class LinkListCycle {
	
	public static class ListNode{
		int val;
		ListNode next;
	}
	
	public boolean hasCycle(ListNode head) {
		
		if(head == null || head.next == null) return false;
		
		ListNode headDash = head.next;
		while(head.next != null && headDash.next != null && 
				headDash.next.next != null && !(head == headDash)){
			head = head.next;
			headDash = headDash.next.next;
		}
		
		if(head == headDash) return true;
		return false;
	        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
