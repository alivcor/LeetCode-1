package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ID451_SortCharacterByFrequency {
	public String frequencySort(String s) {
        if(s == null || s.length() <= 2) return s;
        
        char[] array = s.toCharArray();
        int[] count = new int[256];
        for(int i = 0; i < array.length; i++) count[array[i]]++;
        Map<Integer, List<Character>> map = new HashMap<>();
        for(int i = 0; i < count.length; i++){
            if(count[i] == 0) continue;
            if(map.get(count[i]) == null) map.put(count[i], new ArrayList<>());
            map.get(count[i]).add((char)i);
        }
        
        Integer[] freq = new Integer[map.keySet().size()];
        int index = 0;
        for(Integer val : map.keySet()) freq[index++] = val;
        Arrays.sort(freq, (a,b) -> (b - a));
        
        StringBuilder result = new StringBuilder();
        for(int f : freq){
            for(char c : map.get(f)){
                char[] temp = new char[f];
                Arrays.fill(temp, c);
                result.append(String.valueOf(temp));
            }
        }
        
        return result.toString();
        
    }
}
