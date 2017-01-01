package com.leetcode.solved;

public class ID477_TotalHammingDistance {

	/*
    In naive solution we can do O(N^2) solution. Calculate hamming distance of every pair of number and return the sum.
    
    Optimized: O(N) solution.
    For each of the 32 bits in an integer, count the number of set bits(set_i) on each location.
    Total number of unset bits = (nums.length - set_i)
    So if for a position i, if the total count of set bits is set_i and unset bit is unset_i
    Total hamming distance considering only this position would be = (set_i)*(unset_i)
    Aggregate all of them.
    */
//	public int totalHammingDistance(int[] nums) {
//        if(nums == null || nums.length <= 1) return 0;
//        int val = 0;
//        int[] setBits = new int[32];
//        for(int i = 0; i < nums.length; i++){
//            for(int j = 0; j < 32; j++){
//                setBits[j] += ((nums[i]&(1<<j)) == 0) ? 0 : 1; 
//            }
//        }
//        
//        for(int i = 0; i < 32; i++){
//            val += (nums.length - setBits[i])*setBits[i];
//        }
//        return val;
//        
//    }
	
	//constant space solution
    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        
        int val = 0;
        for(int i = 0; i < 32; i++){
            int bitC = 0;
            for(int j = 0; j < nums.length; j++){
                bitC += (nums[j]>>i)&1;
            }
            val += bitC*(nums.length - bitC);
        }
        
        return val;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
