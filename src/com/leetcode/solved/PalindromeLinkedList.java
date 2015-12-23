package com.leetcode.solved;


public class PalindromeLinkedList {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
		@Override
		public String toString() {
			return "[val=" + val + ", next=" + next + "]";
		}
	  
	}
/*	
	public static ListNode reverse(ListNode list){
		if(list == null || list.next == null)
			return list;
		
		ListNode head = list;
		ListNode updatedHead = reverse(list.next);
		head.next.next = head;
		head.next = null;
		
		return updatedHead;
	}
	public static ListNode reverseItr(ListNode list){
		if(list == null || list.next == null) return list;
		
		ListNode current = list;
		ListNode prev = null;
		
		while(current != null){
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		
		return prev;
	}
	
*/	
	static class Result{
		ListNode node;
		boolean value;
		
		public Result(ListNode node, boolean value){
			this.node = node;
			this.value = value;
		}
	}
	public static boolean isPalindrome(ListNode head){
		int length = 0;
		ListNode current = head;
		while(current != null){
			current = current.next;
			length++;
		}
		
		return isPalinUtil(head, length).value;
	}
	public static Result isPalinUtil(ListNode head,int length){
		//We have reached the middle of the palindrome.
		if(length == 0)
			return new Result(head, true);
		if(length == 1)
			return new Result(head.next, true);
		Result result = isPalinUtil(head.next, length-2);
		if(!result.value)
			return result;
		
		return new Result(result.node.next,head.val == result.node.val);			
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode curr = head;
		for(int i = 2; i < 5; i++){
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		for(int i = 3; i > 0; i--){
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		System.out.println(head);
		System.out.println(isPalindrome(head));

	}

}
