package com.leetcode.solved;

import java.util.Arrays;

public class RearrangeStringKDistanceApart {
	public static String rearrangeString(String str, int k) {
        int[] countArray = new int[26];
        for(int i = 0; i < str.length(); i++) countArray[str.charAt(i) - 'a']++;
        //everytime find the most frequent and find its last index.
        int lastIndexArray[] = new int[26];
        Arrays.fill(lastIndexArray, Integer.MIN_VALUE);
        StringBuilder result = new StringBuilder();
        int index = 0;
        while(result.length() < str.length()){
            char sol = findMostFrequent(countArray, lastIndexArray, index,k);
            if(sol == '0') return "";
            countArray[sol - 'a']--;
            lastIndexArray[sol - 'a'] = index;
            result.append(sol);
            index++;
        }
        
        return result.toString();
    }
    
    private static char findMostFrequent(int[] countArray, int lastIndexArray[], int index, int k){
        char sol = '0';
        int freqSol = 0;
        for(int i = 0; i < 26; i++){
            if(countArray[i] > freqSol && (lastIndexArray[i] == Integer.MIN_VALUE || lastIndexArray[i] + k <= index)){
                sol = (char)(i + 'a');
                freqSol = countArray[i];
            }
        }
        return sol;
    }
	public static void main(String[] args) {
		System.out.println(rearrangeString("aa", 3));
	}

}
