package com.leetcode.solved;

public class SqrtX {
	
	public static int mySqrt(int num) {
		if(num <= 1) return num;
		return binSrch(1, Integer.MAX_VALUE, num);
	}
	
	public static int binSrch(int start, int end, int val){
		if(end <= start) return start;
		int mid = start + (end - start)/2;
		
		if(mid > val/mid) return binSrch(start, mid-1, val);
		if(mid + 1 > val/(mid+1)) return mid;
		return binSrch(mid+1, end, val);
	}
	
	
	public static int mySqrtBit(int num){
		long x = num;
		while(x*x > num){
			x = (x + num/x)/2;
		}
		return (int)x;
	}


	public static void main(String[] args) {
		System.out.println(mySqrtBit(2147483647));
		System.out.println(mySqrtBit(4));
		System.out.println(mySqrtBit(9));
		System.out.println(mySqrtBit(169));
		System.out.println(mySqrtBit(111));
	}

}
