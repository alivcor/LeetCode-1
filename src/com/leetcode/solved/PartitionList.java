package com.leetcode.solved;


public class PartitionList {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	      
}
	public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        
        while(head != null){
            if(head.val < x){
                    curr1.next = head;
                    curr1 = curr1.next;
            }else{
                    curr2.next = head;
                    curr2 = curr2.next;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = head2.next;
        
        return head1.next;
    }

}
