package com.leetcode.solved;

public class FirstBadVersion {

	private static boolean isBadVersion(int version){
		if(version >=2) return true;
		return false;
	}
	public static int firstBadVersion(int n) {
		return binarySearch(1, n);
    }
	
	private static int binarySearch(int start, int end){
		if(start == end && isBadVersion(start)) return start;
		int mid = start + (end-start)/2;
		if(isBadVersion(mid)){
			if(mid == start || !isBadVersion(mid-1)) return mid;
			return binarySearch(start, mid-1);
		}
		return binarySearch(mid+1, end);
	}
	public static void main(String[] args) {
		System.out.println(firstBadVersion(2));

	}

}
