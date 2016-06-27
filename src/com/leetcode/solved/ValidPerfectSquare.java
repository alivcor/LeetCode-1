package com.leetcode.solved;

public class ValidPerfectSquare {
	
	
	public static boolean isPerfectNW(int num){
		if(num < 0) return false;
		if(num <= 1) return true;
		
		double val = num;
		while(val * val > num){
			val = val - (val*val + num)/(2*val);
		}
		
		System.out.println(val);
		return (int)val * (int)val == num;
	}
	
	public static boolean isPerfectSquare(int num) {
		if(num < 0) return false;
		if(num <= 1) return true;
		int val = 1;
		
		while(val*val > 0 && val*val < num) val*=2;
		if(val * val <  0) return false;
		if(val*val == num) return true;
		return binarySearch(val/2, val, num);
    }
	private static boolean binarySearch(int start, int end, int num){
		if(end < start) return false;
		if(end == start) return (start*start == num);
		
		int mid = (start + end)/2;
		if(mid*mid == num) return true;
		if(mid*mid < num) return binarySearch(mid+1, end, num);
		return binarySearch(start, mid-1, num);
	}

	public static void main(String[] args) {
		System.out.println(isPerfectNW(16));
		
		

	}

}
