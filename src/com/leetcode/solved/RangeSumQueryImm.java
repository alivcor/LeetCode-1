package com.leetcode.solved;

public class RangeSumQueryImm {
	
	int nums[];
	int sumArray[];
	public RangeSumQueryImm(int[] nums){
		this.nums = nums;
		sumArray = new int[nums.length+1];
		sumArray[0] = 0;
		for(int i = 1; i <= nums.length;i++){
			sumArray[i] = sumArray[i-1] + nums[i-1]; 
		}
	}
	
	public int sumRange(int i, int j) {
        return (sumArray[j+1]-sumArray[i]);
    }

	public static void main(String[] args) {
		int array[] = {-2, 0, 3, -5, 2, -1};
		RangeSumQueryImm node = new RangeSumQueryImm(array);
		System.out.println(node.sumRange(0, 2));
		System.out.println(node.sumRange(2, 5));
		System.out.println(node.sumRange(0, 5));

	}

}
