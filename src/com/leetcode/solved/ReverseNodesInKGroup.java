package com.leetcode.solved;


public class ReverseNodesInKGroup {
	private static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
		@Override
		public String toString() {
			return "[val=" + val + ", next=" + next + "]";
		}
		
	}
	 private boolean confirmSize(ListNode head, int size){
	        while(head != null){
	            head = head.next;
	            size--;
	            if(size == 0) return true;
	        }
	        return false;
	    }
	    public ListNode reverseKGroup(ListNode head, int size) {
	        if(!confirmSize(head,size)) return head;
	        
	        ListNode newTail = head;
	        ListNode current = head;
	        ListNode prev = null;
	        ListNode rest = null;
	        int k = size;
	        while(k > 0){
	            rest = current.next;
	            current.next = prev;
	            prev = current;
	            current = rest;
	            k--;
	        }
	        
	        head.next = reverseKGroup(rest,size);
	        return prev;
	        
	    }

}
