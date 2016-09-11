package com.leetcode.solved;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import apple.laf.JRSUIConstants.Hit;
public class HitCounter {

    /** Initialize your data structure here. */
    Deque<Integer> deque;
    Map<Integer,Integer> countMap; 
    public HitCounter() {
         deque = new LinkedList<>();
         countMap = new HashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(!deque.isEmpty() && deque.getLast() == timestamp) countMap.put(timestamp,countMap.get(timestamp) + 1);
        else {
            deque.addLast(timestamp);
            countMap.put(timestamp,1);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int firstTime = timestamp - 300;
        while(!deque.isEmpty() && deque.getFirst() <= firstTime){
             countMap.remove(deque.removeFirst());
        }
        
        int total = 0;
        for(int curVal : countMap.values()) total += curVal;
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */