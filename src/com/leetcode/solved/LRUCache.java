
package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	public static class DLNode{
		int key;
		int val;
		DLNode next;
		DLNode prev;
		public DLNode(){}
		public DLNode(int key,int val) {
			this.key = key;
			this.val = val;
			this.next = this;
			this.prev = this;
		}
		@Override
		public String toString() {
			return "DLNode [key=" + key + ", val=" + val + "]";
		}
		
	}
	
	private DLNode head, tail;
	private int capacity;
	Map<Integer, DLNode> map;
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, LRUCache.DLNode>();
        head = new DLNode();
        tail = new DLNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        bringToFront(key);
        return map.get(key).val;
    }

	public void set(int key, int value) {
        if(map.containsKey(key)){
        	bringToFront(key);
        	map.get(key).val = value;
        }else{
        	addKey(key, value);
        }
    }
	private void addKey(int key, int value) {
		if(capacity == 0) return;
		if(map.size() == this.capacity){
			map.remove(tail.prev.key);
			DLNode newTail = tail.prev.prev;
			newTail.next = tail;
			tail.prev = newTail;
		}
		map.put(key, new DLNode(key,value));
		DLNode newHead = map.get(key);
		DLNode oldHead = head.next;
		newHead.next = oldHead;
		head.next = newHead;
		newHead.prev = head;
		oldHead.prev = newHead;  
		
	}

	private void bringToFront(int key) {
		DLNode newHead = map.get(key);
		DLNode prev = newHead.prev;
		DLNode next = newHead.next;
		next.prev = prev;
		prev.next = next;
		
		DLNode oldHead = head.next;
		newHead.next = oldHead;
		head.next = newHead;
		newHead.prev = head;
		oldHead.prev = newHead;  
	}
	
	public static void main(String[] args){
		//1,[set(2,1),get(2),set(3,2),get(2),get(3)]
		
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		System.out.println(cache.get(2));
		cache.set(3, 2);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
	}
}
/*
Map<Value,Pointer> 
as long as map.size < sizeLRU keep adding, while adding check if element already exist, bring to front
if cache is full, delete the last element and add to first.
*/