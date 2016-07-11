package com.leetcode.solved;



public class SortList {
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			super();
			this.val = val;
		}
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
		
	}
	private static ListNode merge(ListNode head1, ListNode head2){
		ListNode current = new ListNode(-1);
		ListNode head = current;
		while(head1 != null && head2 != null){
			if(head1.val < head2.val){
				current.next = head1;
				head1 = head1.next;
			}else{
				current.next = head2;
				head2 = head2.next;
			}
			current = current.next;
		}
		while(head2 != null){
			current.next = head2;
			current = current.next;
			head2 = head2.next;
		}
		while(head1 != null){
			current.next = head1;
			current = current.next;
			head1 = head1.next;
		}
		return head.next;
	}
	public static ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		int length = 0;
        ListNode current = head;
        while(current != null && length++ >= 0) current = current.next;
        current = head;
        length = length/2;
        while(length-- > 1) current = current.next;
        ListNode rest = current.next;
        current.next = null;
		
        return merge(sortList(head), sortList(rest));
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(9);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(91);
		head.next.next.next.next = new ListNode(5);
		System.out.println(sortList(head));

	}

}
