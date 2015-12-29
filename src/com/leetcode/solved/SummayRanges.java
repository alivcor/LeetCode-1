package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class SummayRanges {

	public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        int currentSeqLen = 1;
        for(int i = 1; i < nums.length; i++){
        	if(nums[i] == nums[i-1] + 1){
        		currentSeqLen++;
        	}else if(currentSeqLen == 1){
        		list.add(nums[i-1]+"");
        		currentSeqLen = 1;
        	}else{
        		list.add((nums[i-1]- currentSeqLen + 1) + "->" + nums[i-1]);
        		currentSeqLen = 1;
        	}
        }
        
        if(currentSeqLen == 1){
    		list.add(nums[nums.length-1]+"");
    	}else{
    		list.add((nums[nums.length-1]- currentSeqLen + 1) + "->" + nums[nums.length-1]);
    		currentSeqLen = 1;
    	}
        
        return list;
    }
	public static void main(String[] args) {
		int array[] = {0,1,2,4,5,7};
		System.out.println(summaryRanges(array));

	}

}
