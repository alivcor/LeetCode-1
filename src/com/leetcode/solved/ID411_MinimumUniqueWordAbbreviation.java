package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class ID411_MinimumUniqueWordAbbreviation {

	/*
    https://discuss.leetcode.com/topic/61690/python-with-bit-masks/2
    https://discuss.leetcode.com/topic/61457/c-bit-manipulation-dfs-solution
    
    TARGET: apple
    DICT:   apply, tuple
    Intger: 00001, 11000
    For every word in the dictionary, do a XOR with the target word.
    For every letter that is different put a 1, else 0.
    */
    static List<Integer> convertWordsToInteger(char[] target, String[] dict){
        List<Integer> values = new ArrayList<>();
        for(String w : dict){
            if(target.length != w.length()) continue;
            int curVal = 0;
            for(int i = 0; i < target.length; i++){
                if(target[i] != w.charAt(i)) curVal |= (1<<(target.length - i - 1));
            }
            values.add(curVal);
        }
        return values;
    }
    /*
    Mask is an integer representation of abbreviation. 
    Every on bit in mask represents the actual character, while every off bit sequence of int.
    Example apple -> 10010 -> a2a1
    */
    static String convertToAbbr(char[] target, int mask){
        String binStr = Integer.toBinaryString(mask);
        StringBuilder result = new StringBuilder();
        int count = 0;
        for(int i = 0; i < target.length; i++){
            if((mask&(1<<(target.length - i - 1))) > 0){
                //the first bit was 1.
                if(count == 0) result.append(target[i] + "");
                else result.append(count + "" + target[i]);
                count = 0;
            } else count++;
        }
        if(count > 0) result.append(count + "");
        return result.toString();
    }
    
    static int countDigit(String val){
    	int count = 0;
    	for(int i = 0; i < val.length(); i++) if(Character.isDigit(val.charAt(i))) count++;
    	return count;
    }
    /*
    Every word in dict is converted to a bit representation.
    Now for for every integer from 1 bit to len(target) bit, see if this integer makes a valid mask.
    If yes, convert and return.
    */
    public static String minAbbreviation(String target, String[] dictionary) {
        if(dictionary == null || dictionary.length == 0) 
            return (target == null) ? "0" : target.length() + "";
            
        List<Integer> values = convertWordsToInteger(target.toCharArray(), dictionary);
        if(values.size() == 0) return target.length() + "";
        String min = target;
        for(int i = 1; i < Math.pow(2, target.length()); i++){
            boolean isValid = true;
            for(Integer val : values){
                if((val&i) == 0) {
                    isValid = false;
                    break;
                }
            } 
            if(isValid) {
            	String update = convertToAbbr(target.toCharArray(), i);
            	min = (min.length() > update.length() || (min.length() == update.length() && countDigit(min) < countDigit(update))) ? update : min; 
            }
        }
        return min;
    }
	public static void main(String[] args) {
		
		System.out.println(minAbbreviation("aaaaaxaaaaa", new String[]{"bbbbbxbbbbb"}));

	}

}
