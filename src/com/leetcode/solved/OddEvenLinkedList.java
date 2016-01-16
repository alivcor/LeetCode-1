package com.leetcode.solved;

public class OddEvenLinkedList {

	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	
	/**If the head is null or of a single element: Return head.
	 * Split the original list into two lists, one for even, other for odd.
	 * 
	 * In the loop, point the odd list to its 1 hop next, and similar to even.
	 * Run the loop till we don't have any more additions in the above two list.
	 * 
	 * In the end, attach even list's head to the tail of currentOdd.
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode evenHead = head.next;
		ListNode currOdd = head;
		ListNode currEven = evenHead;
		
		while(currEven != null && currEven.next != null){
			currOdd.next = currEven.next;
			currEven.next = currEven.next.next;
			currOdd = currOdd.next;
			currEven = currEven.next;
		}
		currOdd.next = evenHead;
		return head;
	}
}
/*
 *Test cases:
 *1. Null: handled
 *2. 1 element : Handled
 *3. Odd count: Handled
 *4. Even count: handled  
 */
