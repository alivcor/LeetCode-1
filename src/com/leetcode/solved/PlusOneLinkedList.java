package com.leetcode.solved;


public class PlusOneLinkedList {
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	public ListNode plusOne(ListNode head) {
        head = plusOneUtil(head);
        if(head.val >= 10){
            ListNode carry = new ListNode(1);
            carry.next = head;
            head.val = head.val%10;
            return carry;
        }
        return head;
        
    }
    public ListNode plusOneUtil(ListNode head) {
        if(head == null) return new ListNode(1);
        if(head.next == null){
            head.val += 1;
            return head;
        }
        
        head.next = plusOneUtil(head.next);
        head.val += head.next.val/10;
        head.next.val = head.next.val%10;
        return head;
    }

}
