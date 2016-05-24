package com.leetcode.solved;

public class InsertionSortLL {

	public class ListNode {
		      int val;
		      ListNode next;
		     ListNode(int x) { val = x; }
	}
	
	private static ListNode sortedInsert(ListNode head, ListNode cur){
		if(cur.val <= head.val){
			cur.next = head;
			return cur;
		}
		ListNode saveHead = head;
		//cur.val is greater than head.val
		while(head.next != null && head.next.val < cur.val){
			head = head.next;
		}
		cur.next = head.next;
		head.next = cur;
		
		return saveHead;
	}
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode result = head;
		ListNode current = head.next;
		result.next = null;
		while(current != null){
			ListNode rest = current.next;
			result = sortedInsert(result, current);
			current = rest;
		}
		
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
