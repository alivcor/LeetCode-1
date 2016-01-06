package com.leetcode.solved;

public class UglyNumber {
	/*
	 * If the only factors of a number are 2, 3 and 5.
	 * Keep dividing the number by them. If no more division and number == 1.
	 * Ugly
	 * Else not.
	 */
	public boolean isUgly(int num) {
        if(num <= 0) return false;
        while(num % 2 == 0) num /= 2;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        
        return num == 1;
    }
}
