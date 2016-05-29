package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicateFromSortedList2 {
	
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
		
	}
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        ListNode current = head;
        while(current != null){
        	count.compute(current.val, (key,val) -> val =  val == null ? 1 : val + 1);
        	current = current.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        current = dummy;
        while(current != null && current.next != null){
        	if(count.get(current.next.val) > 1) current.next = current.next.next;
        	else current = current.next;
        }
        
        return dummy.next;
    }

}
