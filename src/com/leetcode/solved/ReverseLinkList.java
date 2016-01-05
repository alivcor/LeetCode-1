package com.leetcode.solved;

public class ReverseLinkList {
	 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	/*
	 * If head is null or a single node list = ReverseList == List.
	 * Else:
	 * 1 -> 2 -> 3 -> 4. to 4 -> 3 -> 2 -> 1
	 * 
	 * Steps:
	 * Keep the head aside and recurse on rest. In this case that would return:
	 * 4 -> 3 -> 2. At this point of time, we need to attach head to end of list.
	 * So before calling the recursive function, save the pointer to 2(rest).
	 * 
	 * After recursion point the next pointer of rest to head. (2 -> 1).
	 * At the same time free the next pointer of head by assigning it to null.
	 * So the final list is :
	 * 4 -> 3 -> 2 -> 1.
	 * Return the list that we got from recursive function.
	 */
    public ListNode reverseList(ListNode head) {
    
    	if(head == null || head.next == null) return head;
    	
    	ListNode rest = head.next;
    	ListNode revRest = reverseList(rest);
    	rest.next = head;
    	head.next = null;
    	
    	return revRest;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
