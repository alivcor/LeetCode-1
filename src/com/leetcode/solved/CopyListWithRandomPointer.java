package com.leetcode.solved;

public class CopyListWithRandomPointer {
	class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
	};
	
	public RandomListNode copyRandomList(RandomListNode root){
        if(root == null) return root;
      RandomListNode head = root;
      while(head != null){
        RandomListNode next = head.next;
        RandomListNode copy = new RandomListNode(head.label);
        head.next = copy;
        copy.next = next;
        head = next;
        
      }
      
      head = root;
      
      while(head != null){
        if(head.random != null){
          head.next.random = head.random.next;
        }
        head = head.next.next;
      }
      
      head = root;
      RandomListNode newHead = head.next;
      RandomListNode newRoot = head.next;
      
      while(head != null){
        head.next = head.next.next;
        if(newHead.next != null){
          newHead.next = newHead.next.next;
        } 
        head = head.next;
        newHead = newHead.next;
      }
      
      return newRoot;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
