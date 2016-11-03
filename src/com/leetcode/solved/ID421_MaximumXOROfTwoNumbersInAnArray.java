package com.leetcode.solved;

import java.util.HashSet;
import java.util.Set;

public class ID421_MaximumXOROfTwoNumbersInAnArray {
	/*
    We will start by looking at the leftmost bit(Most Significant bit) that is we are able to set that, 
    To do that we find out all possible scenarios from the nums array, 
    starting with only 1 bit(31st) 2 bits(31st and 30th)
    for example if we have both 0 followed by 30 zeros and 1 followed by 30 ones, we can be sure that this bit would be
    set in the XOR, similarly we will have
    00 follow 29zeros, 10follow 29zeors adn 01 follow 29 zeros in the set
    at this point of time tmp would be 1follow30zeroes | 1<<29 
    if so if we have a number in the set that is tmp XOR any other number, it means we have two numbers in the set
    that xors to tmp and thus would be the maximum number
    */
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            //starts with 1 follow 30 zeros, 11follow 29zeros, 111 follow 28 zeros
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            //set will contain all possible scenarios present in the nums array with last i bits masked.
            for(int num : nums){
                set.add(num & mask);
            }
            //tmp is the maximum number that can be formed, it can only happen if the current xor bit is set to 1.
            //now if there are two numbers in the set that xors upto this tmp, this is the new max,
            //if there are no such numbers, we will leave the max value as it is, 
            // A^B = C  ==> A^C = B
            //The point here is: 1000 > 0111
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                    //since we are looking at only one bit, if it is set, we can safely break
                }
            }
        }
        return max;
    }

}
