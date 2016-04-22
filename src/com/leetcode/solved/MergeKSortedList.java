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
	
	public ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeKLists(lists,0,lists.length-1);
    }
	
	public ListNode merge(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		if(l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		}else{
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
	public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if(start > end) return null;
        if(start == end) return lists[start];
        if(end - start == 1) return merge(lists[start],lists[end]);
        int mid = (start + end)/2;
        return merge(mergeKLists(lists, start, mid), mergeKLists(lists, mid+1, end));
    }
}
