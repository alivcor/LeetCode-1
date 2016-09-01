package com.leetcode.solved;

public class TwoSumIIInputArraySorted {
	public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length <= 1) return new int[2];
        int indices[] = new int[2];
        indices[0] = 1;
        indices[1] = numbers.length;
        
        while(indices[0] < indices[1]){
            if(numbers[indices[0]-1] + numbers[indices[1]-1] > target) indices[1]--;
            else if(numbers[indices[0]-1] + numbers[indices[1]-1] < target) indices[0]++;
            else break;
        }
        
        return indices;
    }

}
