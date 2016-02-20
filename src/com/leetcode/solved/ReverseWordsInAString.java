package com.leetcode.solved;

public class ReverseWordsInAString {
	
	public static String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
        if(s == null || s.length() == 0) return s;
        String[] sentence = s.split(" ");
        int i = 0;
        while(i < (sentence.length - i - 1)){
            String temp = sentence[i];
            sentence[i] = sentence[sentence.length - i - 1];
            sentence[sentence.length - i - 1] = temp;
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < sentence.length; i ++){
            sb.append(sentence[i] + " ");
        }
        
        return sb.toString().trim();
        
    }

	public static void main(String[] args) {
		System.out.println(reverseWords("   a   b "));

	}

}
