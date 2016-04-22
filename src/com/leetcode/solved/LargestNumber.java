package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	
	public static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        List<String> listS = new ArrayList<String>();
        for(int i : nums) listS.add(String.valueOf(i));
        Collections.sort(listS, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
        if("0".equals(listS.get(0))) return "0";
        StringBuilder sb = new StringBuilder();
        for(String i : listS) sb.append(i);
        return sb.toString();
    }

	public static String largeNum(int[] nums){
	
		String[] array = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(array, (a,b) -> (b + a).compareTo(a + b));
		return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
		
        
	}
	public static void main(String[] args) {
		int array[] = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(array));
		System.out.println(largeNum(array));

	}

}

/*
Notes:
Do this: 
public int compare(String str1, String str2){
            String s1 = str1+str2;
            String s2 = str2+str1;
            return s1.compareTo(s2);
}

Instead of:
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

*/
