package com.leetcode.solved;

public class Add2Numbers {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
			@Override
			public String toString() {
				return "ListNode [val=" + val + ", next=" + next + "]";
			}
		      
	}
	
	public static ListNode convertToList(int number){
		ListNode head = null;
		ListNode current = null;
		while(number != 0){
			if(head == null){
				head = new ListNode(number%10);
				current = head;
			}else{
				current.next = new ListNode(number%10);
				current = current.next;
			}
			number = number/10;
		}
		
		return head;
	}
	/*
	 * If one/both of them is null, return accordingly.
	 * If length of one is different from other.
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if (l1 == null || l2 == null)
			return (l1 == null) ? l2 : l1;
		
		ListNode result = null;
		ListNode resultCurr = null;
		int carry = 0;
		//till the time both numbers are same length
		while(l1 != null && l2 != null){
			int sum = l1.val + l2.val + carry;
			if (result == null){
				result = new ListNode(sum%10);
				resultCurr = result;
			}else{
				resultCurr.next = new ListNode(sum%10);
				resultCurr = resultCurr.next;
			}
			carry = sum/10;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		if(carry != 0 && l1 == null && l2 == null)
			resultCurr.next = new ListNode(carry);
		
		if(l1 == null){
			adjustNumber(l2, carry, resultCurr);
		}
		if(l2 == null){
			adjustNumber(l1, carry, resultCurr);
		}
		
		return result;
	}
	
	public static void adjustNumber(ListNode list, int carry, ListNode resultCurr){
		while(list != null){
			int sum = list.val + carry;
			resultCurr.next = new ListNode(sum%10);
			resultCurr = resultCurr.next;
			carry = sum/10;
			list = list.next;
		}
		
		if(carry != 0)
			resultCurr.next = new ListNode(carry);
	}
	
	public static void main(String[] args) {
//		System.out.println(addTwoNumbers(convertToList(12),convertToList(12)));
//		System.out.println(addTwoNumbers(convertToList(17),convertToList(14)));
//		System.out.println(addTwoNumbers(convertToList(95),convertToList(14)));
		System.out.println(addTwoNumbers(convertToList(999),convertToList(1)));

	}

}
