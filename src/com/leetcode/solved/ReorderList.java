package com.leetcode.solved;

public class ReorderList {

	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			super();
			this.val = val;
		}
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
		
	}
	private static ListNode reverse(ListNode head){
		if(head == null || head.next == null) return head;
		
		ListNode current = head;
		ListNode prev = null;
		while(current != null){
			ListNode rest = current.next;
			current.next = prev;
			prev = current;
			current = rest;
		}
		return prev;
	}
	
	private static ListNode interleave(ListNode head1, ListNode head2){
		ListNode current = new ListNode(-1);
		ListNode head = current;
		while(head1 != null && head2 != null){
			ListNode rest1 = head1.next;
			ListNode rest2 = head2.next;
			current.next = head1;
			head1.next = head2;
			current = head2;
			head2.next = null;
			head1 = rest1;
			head2 = rest2;
		}
		if(head2 != null) current.next = head2;
		return head.next;
	}
	public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
         
        int length = 0;
        ListNode current = head;
        while(current != null && length++ >= 0) current = current.next;
        current = head;
        length = length/2;
        while(length-- > 1) current = current.next;
        ListNode rest = reverse(current.next);
        current.next = null;
        head = interleave(head, rest);
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		reorderList(head);
//		System.out.println(reverse(head));
		System.out.println(head);

	}

}
