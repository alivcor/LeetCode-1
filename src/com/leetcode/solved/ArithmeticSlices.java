package com.leetcode.solved;

public class ArithmeticSlices {

	public static int numberOfArithmeticSlices(int[] A) {
		if(A == null || A.length <= 2) return 0;

		int index = 0;
		int count = 2;
		int diff = A[1] - A[0];
		int total = 0;
		while(index + count < A.length){
			if(A[index + count] - A[index + count - 1] == diff) count++;
			else{
				total += ((count - 1)*(count - 2))/2;
				index = index + count - 1;
				diff = A[index + 1] - A[index];
				count = 2;
			}
		}
		total += ((count - 1)*(count - 2))/2;
		return total;
    }
	
	public static void main(String[] args) {
		System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,5,8,11}));
		System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,5,7,9,11,13}));

	}

}
