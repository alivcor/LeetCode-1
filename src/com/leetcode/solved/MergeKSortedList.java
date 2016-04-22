package com.leetcode.solved;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

	static public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
		 val = x; 
		 }
	}
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode head = new ListNode(0);
        ListNode current = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,(a,b) -> Integer.compare(a.val, b.val));  
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) queue.add(lists[i]);
        }
        while(!queue.isEmpty()){
        	ListNode top = queue.poll();
        	if(top.next != null){
        		queue.add(top.next);
        		top.next = null;
        	}
        	current.next = top;
        	current = current.next;
        }    
        return head.next;
    }
}
