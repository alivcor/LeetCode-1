package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {

	public static List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 10) return Collections.emptyList();
        Map<String, Integer> freq = new HashMap<String, Integer>();
        for(int i = 0; i < s.length() - 10 + 1; i++){
        	freq.compute(s.substring(i,i+10),(key,val) -> val = (val == null) ? 1 : val + 1);
        }
        
        List<String> result = new ArrayList<>();
        for(String key : freq.keySet()){
        	if(freq.get(key) > 1) result.add(key);
        }
        return result;
    }
	
	
	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

	}

}
