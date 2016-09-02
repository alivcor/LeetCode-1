package com.leetcode.solved;

public class FindTheCelebrity {
	private boolean knows(int i , int j){
		
	}
	public int findCelebrity(int n) {
        if(n == 1) return -1;
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate,i)) candidate = i;
        }
        
        for(int i = 0; i < n; i++){
            if(i == candidate) continue;
            if(knows(i,candidate) && !knows(candidate,i))continue;
            return -1;
        }
        return candidate;
        
    }
}
