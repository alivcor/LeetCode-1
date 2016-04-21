package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	
	public static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        List<String> listS = new ArrayList<String>();
        for(int i : nums) listS.add(i+"");
        Collections.sort(listS, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) return o1.compareTo(o2);
				int i = 0;
				while(i < o1.length() && i < o2.length()){
					if(o1.charAt(i) == o2.charAt(i)){
						i++;
						continue;
					}
					if(o1.charAt(i) > o2.charAt(i)) return 1;
					return -1;
			
				}
				if(i == o1.length()){
					return compare(o1, o2.substring(i));
				}
				return compare(o1.substring(i), o2);
			}
		});
        Collections.reverse(listS);
        StringBuilder sb = new StringBuilder();
        for(String i : listS) sb.append(i);
        
        boolean areAZero = true;
        for(int i = 0; i < sb.length(); i++){
        	if(sb.charAt(i) != '0'){
        		areAZero = false;
        		break;
        	}
        }
        if(areAZero) return "0";
        return sb.toString();
    }

	public static void main(String[] args) {
		int array[] = {0,0};//{3, 30, 34, 5, 9};
		System.out.println(largestNumber(array));

	}

}
