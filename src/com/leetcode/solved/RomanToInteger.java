package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	
	private static Map<String,Integer> createMap(){
		Map<String,Integer> romIntMap = new HashMap<String, Integer>();
		romIntMap.put("I",1);
		romIntMap.put("IV",4);
		romIntMap.put("V",5);
		romIntMap.put("IX",9);
		romIntMap.put("X",10);
		romIntMap.put("XL",40);
		romIntMap.put("L",50);
		romIntMap.put("XC",90);
		romIntMap.put("C",100);
		romIntMap.put("CD",400);
		romIntMap.put("D",500);
		romIntMap.put("CM",900);
		romIntMap.put("M",1000);
		return romIntMap;
	}
	public static int romanToInt1(String s) {
        if(s.length() == 0) return 0;
        Map<String,Integer> romIntMap = createMap();
        return romanToInt(s, romIntMap);
    }
	
	private static int romanToInt(String s, Map<String,Integer> romIntMap){
		if(s.length() == 0) return 0;
		if(s.length() >= 2 && romIntMap.containsKey(s.substring(0, 2))){
        	return romIntMap.get(s.substring(0,2)) + romanToInt(s.substring(2));
        }
		return romIntMap.get(s.substring(0,1)) + romanToInt(s.substring(1));
	}
	
	
	
	
	
	
    public static int romanToInt(String s) {
        if(s.length() == 0) return 0;
        int[] arrayMap = new int[26];
        arrayMap['I' - 'A'] = 1;
        arrayMap['V' - 'A'] = 5;
        arrayMap['X' - 'A'] = 10;
        arrayMap['L' - 'A'] = 50;
        arrayMap['C' - 'A'] = 100;
        arrayMap['D' - 'A'] = 500;
        arrayMap['M' - 'A'] = 1000;
        
        int result = 0;
        for(int i = 0; i < s.length() - 1; i++){
        	if(arrayMap[s.charAt(i) - 'A'] < arrayMap[s.charAt(i+1) - 'A']) 
        		result -= arrayMap[s.charAt(i) - 'A'];
        	else result += arrayMap[s.charAt(i) - 'A'];
        }
        return result + arrayMap[s.charAt(s.length() - 1) - 'A'];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
