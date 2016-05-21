package com.leetcode.solved;

import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoArrays {
	
	public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        
        Set<Integer> setNum = new HashSet<Integer>();
        Set<Integer> setIntersect = new HashSet<Integer>();
        for(int i : nums1) setNum.add(i);
        for(int i : nums2){
            if(setNum.contains(i)) setIntersect.add(i);
        }
        
        int[] result = new int[setIntersect.size()];
        int i = 0;
        for(int value : setIntersect) result[i++] = value;
        return result;
        
    }

}
