package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class ID448_FindAllNumberDisappearedInAnArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null) return result;
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i]) - 1] < 0) continue;
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
        
        for(int i = 0; i < nums.length; i++) if(nums[i] > 0) result.add(Math.abs(i) + 1);
        return result;
    }
}
