package com.leetcode.solved;

public class LongestIncreasingSubsequence {
	
	public static int LIS(int[] input){
		if(input == null || input.length == 0) return 0;
		
		int[] count = new int[input.length];
		int maxIndex = 0;
		
		for(int i = 0; i < input.length; i++)
			count[i] = 1;
		
		for(int i = 1; i < input.length; i++){
			for (int j = 0; j < i; j++){
				if(count[i] <= count[j] && input[i] > input[j]){
					count[i] = 1 + count[j];
					if(count[maxIndex] < count[i])
						maxIndex = i;
				}
			}
		}
		
		return count[maxIndex];
	}

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
	    System.out.println(LIS(arr));

	}

}
