package com.leetcode.solved;

/*
 * This solution is derived from the basic idea that multiplying any number by 2 keeps the count bits same.
 * So if a number is even, halving the value will also keep the count of bits constant.
 * Similarly every odd number adds one bit to the previous even number.
 */
public class CountingBits {
	public int[] countBits(int num) {
        int[] bits = new int[num + 1];
    
        for(int i = 1; i <= num; i++){
            bits[i] = bits[i/2];
            if(i%2 == 1) bits[i]++; 
        }
        return bits;
    }

}
