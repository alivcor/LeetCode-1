package com.leetcode.solved;

import java.util.Random;

public class ShuffleAnArray {
	int array[];
    public ShuffleAnArray(int[] nums) {
        array = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int result[] = new int[array.length];
        for(int i = 0; i < result.length; i++) result[i] = array[i];
        Random r = new Random();
        for(int i = result.length-1; i > 0; i--){
            int randm = r.nextInt(i+1);
            int temp = result[randm];
            result[randm] = result[i];
            result[i] = temp;
        }
        return result;
    }

}
