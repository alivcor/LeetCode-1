package com.leetcode.solved;

public class ReverseString {
	public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        int i = 0;
        while(i < array.length - i){
            char temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : array) sb.append(c);
        return sb.toString();
    }

}
