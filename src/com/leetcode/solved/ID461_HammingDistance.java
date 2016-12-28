package com.leetcode.solved;

public class ID461_HammingDistance {
	public int hammingDistance(int x, int y) {
        int xor = x^y;
        int count = 0;
        while(xor > 0){
            xor = xor&(xor - 1);
            count++;
        }
        return count;
    }
}

/*
Hamming Distance: Count of places where in binary representation of two integers differ.
1. XOR of 2 Integer
2. Count the total number of on bits in XOR result.
*/
