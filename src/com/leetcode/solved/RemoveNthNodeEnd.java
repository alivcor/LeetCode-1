package com.leetcode.solved;

public class RemoveNthNodeEnd {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
			@Override
			public String toString() {
				return "ListNode [val=" + val + ", next=" + next + "]";
			}
		      
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fwdPointer = head;
		if(n == 0) return head;
		
		int count = 0;
		while(count < n && fwdPointer != null){
			count++;
			fwdPointer = fwdPointer.next;
		}
		if(fwdPointer == null) return head.next;
		//At this point fwdPointer is N positions from start.
		ListNode node = head;
		while(fwdPointer.next != null){
			fwdPointer = fwdPointer.next;
			node = node.next;
		}
		if(node.next != null)node.next = node.next.next;
		return head;
    }
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode current = node1;
		for(int i = 2; i < 3;i++){
			current.next = new ListNode(i);
			current = current.next;
		}
		
		System.out.println(removeNthFromEnd(node1, 2));

	}

}
