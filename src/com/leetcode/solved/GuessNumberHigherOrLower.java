package com.leetcode.solved;

public class GuessNumberHigherOrLower {

	int k;
	
	public GuessNumberHigherOrLower(int k) {
		super();
		this.k = k;
	}
	private int guess(int n){
		if(n == k) return 0;
		if(n > k) return 1;
		return -1;
	}
	 public int guessNumber(int n) {
	        if(n == 1) return 1;
	        return guessNum(1,n);
	    }
	    
	    private int guessNum(int a, int b){
	        if(a == b) return a;
	        int mid = a + (b-a)/2;
	        int guessMid = guess(mid);
	        if(guessMid == 0) return mid;
	        if(guessMid == -1) return guessNum(a,mid-1);
	        return guessNum(mid+1,b);
	    }
}
