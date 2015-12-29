package com.leetcode.solved;

public class CountPrimes {

	public static int countPrimes(int n) {
        if(n == 0 || n == 1 || n == 2) return 0;
        
		boolean array[] = new boolean[n];
		for(int i = 2;i < n; i++){
			for(int j = 2; i*j < n;j++){
				array[i*j] = true;
			}
		}
		
		int count = 0;
		for(int i = 0; i < array.length;i++){
			if(array[i] == false) count++;
		}
		
		return count-2;
    }
	public static void main(String[] args) {
		System.out.println(countPrimes(10));
		System.out.println(countPrimes(20));
		System.out.println(countPrimes(50));

	}

}
