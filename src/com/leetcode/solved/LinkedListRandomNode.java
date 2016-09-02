package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkedListRandomNode {
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public static class ListNode{
		int val;
		ListNode next;
	}
Map<Integer,ListNode> mapNode = new HashMap<Integer,ListNode>();
Random randm = new Random();
public LinkedListRandomNode(ListNode head) {
    int index = 0;
    while(head != null){
        mapNode.put(index++,head);
        head = head.next;
    } 
}

/** Returns a random node's value. */
public int getRandom() {
    return mapNode.get(randm.nextInt(mapNode.size())).val;
}

}
