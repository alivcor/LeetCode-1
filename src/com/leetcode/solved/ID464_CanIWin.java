package com.leetcode.solved;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ID464_CanIWin {

	public static boolean canIWin_(int max, int des) {
        if(max >= des) return true;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 1; i <= max; i++) set.add(i);
        return canIWin(des, set);
    }
    
    public static boolean canIWin(int desiredTotal, TreeSet<Integer> choose) {
        if(desiredTotal <= 0 || choose.ceiling(desiredTotal) != null) return true;
        for(Integer cur : choose){
        	TreeSet<Integer> bla = new TreeSet<>(choose);
            bla.remove(cur);
            if(!canIWin(desiredTotal - cur, bla)) return true;
        }
        return false;
    }
	public static void main(String[] args) {
//		System.out.println(canIWin(10, 11));
		System.out.println(canIWin(10,11));

	}
	
	
	//X----------X--------------X------------------X--------
	/*
	 * Below needs to be done to memoize. 
	 * We should have a way to retrieve the result for a given desired amount at a given set of available values.
	 * Since max available values can be from 1 to 20, we can use a character array (string) as value
	 * So for each desired value and for each string we have a result T or F
	 */
	
	static Map<Integer, Boolean> map;
	static boolean used[];
	public static boolean canIWin(int max, int desired){
		if(desired <= max) return true;
		if(desired == max + 1) return false;
		if(max*(max + 1)/2 < desired) return false;
		
		map = new HashMap<>();
		used = new boolean[max + 1];
		return helper(desired);
	}
	private static boolean helper(int desired){
		if(desired <= 0) return false;
		int num = format(used);
		
		if(!map.containsKey(num)){
			for(int i = used.length - 1; i >= 1; i--){
				if(used[i]) continue;
				used[i] = true;
				boolean oppW = helper(desired - i);
				used[i] = false;
				if(!helper(desired - i)){
					map.put(num, true);
					break;
				}
			}
		}
		return map.get(num);
		
	}
	// transfer boolean[] to an Integer 
    public static int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}
