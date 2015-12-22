package com.leetcode.solved;

public class Intersection2LL {
	static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	      
	}
	
	public static int findLength(ListNode list){
		int length = 0;
		while(list != null){
			list = list.next;
			length++;
		}
		
		return length;
	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        	return null;
        int lengthA = findLength(headA);
        int lengthB = findLength(headB);
        
        while(lengthA > lengthB){
        	headA = headA.next;
        	lengthA--;
        	if(headA == null)
        		return null;
        }
        while(lengthB > lengthA){
        	headB = headB.next;
        	lengthB--;
        	if(headB == null)
        		return null;
        }
        
        //At this point both lists are at the same length from end.
        
        while(headA != null && headB != null && headA != headB){
        	headA = headA.next;
        	headB = headB.next;
        }
        
        return (headA == headB)? headA : null;
    }

	public static void main(String[] args){
		ListNode node = new ListNode(2);
		ListNode node2 = new ListNode(3);
		
		node.next = node2;
		System.out.println(getIntersectionNode(node, node2));
	}
}
