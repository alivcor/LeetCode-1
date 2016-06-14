package com.leetcode.solved;

public class CountNumberWithUniqueDigits {

	public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 0;
        if(n == 1) return 10;
        int sum = 10;
        int currVal = 9;
        int index = 9;
        for(int i = 2; i <= n && i <= 10; i++){
            currVal *= index;
            index--;
            sum += currVal;
        }
        
        return sum;
    }
	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(2));
		System.out.println(countNumbersWithUniqueDigits(3));
		System.out.println(countNumbersWithUniqueDigits(4));

	}

}
