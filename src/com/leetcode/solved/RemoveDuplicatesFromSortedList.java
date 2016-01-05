package com.leetcode.solved;

public class RemoveDuplicatesFromSortedList {

	public class ListNode {
      int val;
      ListNode next;
	  ListNode(int x) { val = x; }
	}
	/*
	 * Delete duplicates from a sorted list.
	 * Traverse the list, keep checking if the value of 
	 * next node is equal to the current, in that case
	 * remove the next node, by pointing next of current to next of next.
	 * Stop when we reach the end of the list.
	 */
	public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.val == current.next.val)
                current.next = current.next.next;
            else{
                current = current.next;
            }
        }
        return head;        
    }
}
