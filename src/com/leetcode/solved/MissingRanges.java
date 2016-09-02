package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	public String createRange(int start, int end){
        if(start == end) return start + "";
        else return start + "->" + end;
    }
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        
        if(nums == null || nums.length == 0){
            list.add(createRange(lower,upper));
            return list;
        }
        
        for(int i = 0; i<nums.length;i++){
            if(lower == nums[i]){
                lower++;
            }
            if(lower < nums[i]){
                list.add(createRange(lower, nums[i]-1));
                lower = nums[i]+1;
            }
        }
        
        if(nums[nums.length-1] < upper)
            list.add(createRange(nums[nums.length-1]+1, upper));
        
        return list;
        
    }

}
