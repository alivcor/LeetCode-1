package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int tInt) {
		long t = tInt;
		if(nums == null || nums.length <= 1 || t < 0 || k < 1) return false;
		Map<Long, Long> map = new HashMap<Long, Long>();
		
		for(int i = 0; i < nums.length; i++){
			long curVal = (long)nums[i] - Integer.MIN_VALUE;
			long bucketkey = curVal/(t+1);
			if(map.containsKey(bucketkey) || (map.containsKey(bucketkey + 1) && map.get(bucketkey + 1) - curVal <= t)
					|| (map.containsKey(bucketkey - 1) && curVal - map.get(bucketkey-1) <= t)) return true;
			if(map.size() >= k) map.remove(((long)nums[i-k] - Integer.MIN_VALUE)/(t+1));
			map.put(bucketkey, curVal);
		}
		
		return false;
    }
}
