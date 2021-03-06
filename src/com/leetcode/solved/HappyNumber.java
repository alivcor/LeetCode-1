package com.leetcode.solved;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	/*
	 * To prevent the number from looping in a cycle, 
	 * We will store all the square sum in a set, return false if repeat.
	 * 
	 * We will run the loop until we have n == 1.
	 * Any cycle would anyway return false.
	 */
	public static boolean isHappy(int n) {
        Set<Integer> setPrevious = new HashSet<Integer>();
        while(n != 1){
            int sqSum = 0;
            while(n > 0){
                sqSum = sqSum + (n%10)*(n%10);
                n = n/10;
            }
            if(sqSum == 1) return true;
            if(setPrevious.contains(sqSum)) return false;
            setPrevious.add(sqSum);
            n = sqSum;
        }
        
        return true;
        
    }

	public static void main(String[] args) {
		System.out.println(isHappy(19));

	}

}
