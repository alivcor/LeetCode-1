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
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o2.val > o1.val) return -1;
				if(o1.val > o2.val) return 1;
				return 0;
			}
		});  
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
