package com.leetcode.solved;

public class DeleteNodeInALinkedList {

	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	};
	/*
	 * Delete a node in the link list given only access to that node.
	 * Given:
	 * Node is not the tail.
	 * 
	 * Idea is to copy the data of next node and delete the next node from the List.
	 */
	public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
