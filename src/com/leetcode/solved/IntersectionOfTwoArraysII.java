package com.leetcode.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
	
	public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null ||
        		nums1.length == 0 || nums2.length == 0) return new int[0];
        
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++){
        	map.compute(nums1[i], (key,v) -> v == null ? 1 : v + 1);
        }
        
        for(int i : nums2){
        	if(map.get(i) != null && map.get(i) != 0){
        		result.add(i);
        		map.compute(i, (key,v) -> v-1);
        	}
        }
        System.out.println(result);
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
        	res[i] = result.get(i);
        }
        return res;
    }
	
	public static void main(String[] args){
		int[] nums1 = {2,2};
		int[] nums2 = {1,2,1,2};
		intersect(nums1, nums2);
		
		
		
	}

}
