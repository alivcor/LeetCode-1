package com.leetcode.solved;

import java.util.Arrays;


public class UglyNumber2 {

	public static int nthUglyNumber(int n) {
		if(n == 0) return 0;
		
		int[] values = new int[n+1];
		int[] index = {1,1,1};
		
		values[1] = 1;
		for(int i = 2; i <= n; i++){
			values[i] = Integer.min(values[index[0]] * 2, Integer.min(values[index[1]] * 3, values[index[2]] * 5));
			if(values[i] == values[index[0]] * 2) index[0]++;
			if(values[i] == values[index[1]] * 3) index[1]++;
			if(values[i] == values[index[2]] * 5) index[2]++;
		}
		
		return values[n];
    }
	public static void main(String[] args) {
		nthUglyNumber(11);
//\		nthUglyNumber(11);

	}

}
