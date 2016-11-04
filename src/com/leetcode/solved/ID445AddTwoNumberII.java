package com.leetcode.solved;

import com.leetcode.solved.Add2Numbers.ListNode;

public class ID445AddTwoNumberII {
	private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverse(head.next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        l1 = reverse(l1);
        l2 = reverse(l2);
        while(l1 != null || l2 != null){
            int sum = carry;
            sum += (l1 == null) ? 0 : l1.val;
            sum += (l2 == null) ? 0 : l2.val;
            curr.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            curr = curr.next;
        }
        
        if(carry != 0) {
            curr.next = new ListNode(carry);
        }
        head = head.next;
        return reverse(head);
    }

}
