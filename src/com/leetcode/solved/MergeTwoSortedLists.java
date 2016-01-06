package com.leetcode.solved;

public class MergeTwoSortedLists {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	/*
	 * MergeTwoList Recursive Implementation.
	 * 
	 * The idea is to keep the smaller value node with us as head,
	 * and recurse on two lists.
	 * Attach the merged list we got from the recursion to smaller head.
	 * Return.
	 */
	public ListNode mergeTwoListsR(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		if(l1.val > l2.val){
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
		l1.next = mergeTwoLists(l1.next, l2);
		return l1;
	}
	/*
	 * Following similar to MergeSort.
	 * If any one of the list is null. Return other.
	 * 
	 * Create a third list and add nodes to it one by one
	 * from other two lists.
	 * Increment the other list in the same fashion until one of list exhausts.
	 * Add remaining elements from the other list.
	 * Return the head of new list.
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode head = l1;
        if(l1.val > l2.val){
            head = l2;
            l2 = l2.next;
        }else{
            l1 = l1.next;
        }
        ListNode current = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                current.next = l2;
                l2 = l2.next;
            }else{
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }
        
        if(l1 != null) current.next = l1;
        if(l2 != null) current.next = l2;
        
        return head;
    }
	
	
	
}
