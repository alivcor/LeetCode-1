package com.leetcode.solved;

public class ReverseLinkedListII {

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
	public static ListNode reverseRe(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode rest = head.next;
		ListNode newHead = reverseRe(head.next);
		rest.next = head;
		head.next = null;
		return newHead;
	}
	
	public static ListNode reverseFirstN(ListNode head, int n){
		if(head == null || head.next == null) return head;
		ListNode current = head;
		ListNode prev = null;
		
		while(current != null && n > 0){
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next; 
			n--;
		}
		head.next = current;
		return prev;
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || head.next == null) return head;
		if(m >= n) return head;
		ListNode current = head;
		ListNode prev = null;
		int countRev = n - m + 1;
		while(m-1 > 0 && current != null){
			prev = current;
			current = current.next;
			m--;
		}
		ListNode rest = reverseFirstN(current, countRev);
		if(prev != null) prev.next = rest;
		else head = rest;
		return head;
		
    }
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode current = root;
		for(int i = 2; i < 7; i++){
			current.next = new ListNode(i);
			current = current.next;
			
		}
		System.out.println(root);
//		System.out.println(reverseRe(root));
//		System.out.println(reverseItr(root));
		System.out.println(reverseBetween(root, 3, 4));

	}

}
