package com.leetcode.solved;

public class RotateList {

	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        ListNode current = head;
        int count = 0;
        while(current != null){
        	current = current.next;
        	count++;
        }
        if(k%count == 0) return head;
        k = count - k%count - 1;
        current = head;
        
        while(k > 0){
        	current = current.next;
        	k--;
        }
        ListNode later = current.next;
        ListNode newHead = later;
        current.next = null;
        while(later.next != null) later = later.next;
        later.next = head;
        
		return newHead;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
