package com.leetcode.solved;

public class PlusOne {
	
	/*
	 * If the number of digit changes by adding 1. We would need to push the other values to the next index.
	 */
	private static int[] insertCarryAtFront(int digits[], int carry){
		
		int newArr[] = new int[digits.length+1];
		if(carry >= 1){
			newArr[0] = carry;
			for(int i = 1; i <= digits.length; i++){
				newArr[i] = digits[i-1];
			}	
		}
		return newArr;
	}
	/*
	 *Start from last and keep updating values till carry is not 1.  
	 */
	public static int[] plusOne(int[] digits) {
        
		if(digits == null || digits.length == 0) return digits;
		
		int carry = 0;
		int index = digits.length-1;
		
		do{
			if(digits[index] == 9){
				digits[index] = 0;
				carry = 1;
				index--;
			}else{
				digits[index] += 1;
				return digits;
			}
		}while(carry != 0 && index >= 0);
		
		return insertCarryAtFront(digits, carry);
    }

	public static void main(String[] args) {
		int digit[] = {9,9,9};
		System.out.println(plusOne(digit));
		

	}

}
