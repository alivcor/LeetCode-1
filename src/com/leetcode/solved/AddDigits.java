package com.leetcode.solved;

public class AddDigits {
	/*
	 * Aim: Keep calculating the sum of the digits until we reach single digit.
	 * 
	 * In below method given a number num.
	 * If it is already single digit: Return.
	 * Find its sum and pass it to the same function.
	 */
	public static int addDigits_RepeatedAddition(int num) {
		if(num >= 0 && num <= 9) return num;
		int sum = 0;
		while(num != 0){
			sum += num%10;
			num /=10;
		}
		return addDigits_RepeatedAddition(sum);
    }
	/*
	 *This is called the digital root.
	 *The digital root of 10 and all the power of 10 is 1.
	 *Every number can be represented as a*10^k + b*10^k-1...
	 *So digital root of a number (a+b+c)%9 = (abc)%9.
	 *Now since 9%9 = 0, but we need 9, so we will have
	 *1 + (n-1)%9 
	 */
	public static int addDigits_Congruence(int num){
		return (1 + (num-1)%9);
	}

	public static void main(String[] args) {
		System.out.println(addDigits_Congruence(38));

	}

}
