package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		if(strs == null || strs.length == 0) return Collections.EMPTY_LIST;
		List<List<String>> result = new ArrayList<List<String>>();
		
		Map<String,List<String>> map = new HashMap<String, List<String>>();
		
		for(String word : strs){
			char[] array = word.toCharArray();
			Arrays.sort(array);
			if(!map.containsKey(new String(array))) map.put(new String(array), new ArrayList<>());
			map.get(new String(array)).add(word);
		}
		
		for(List list : map.values()){
			Collections.sort(list);
			result.add(list);
		}
		
		return result;
    }

	public static void main(String[] args) {
		String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(array));

	}

}
