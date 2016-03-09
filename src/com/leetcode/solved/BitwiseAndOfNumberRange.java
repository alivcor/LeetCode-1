package com.leetcode.solved;

public class BitwiseAndOfNumberRange {

	public int rangeBitwiseAnd(int m, int n) {
		if(m == n) return m;
		int count = 0;
		while(m != n){
			m = m >> 1;
			n = n >> 1;
			count++;
		}
		
		return m<<count;
		
    }
}
