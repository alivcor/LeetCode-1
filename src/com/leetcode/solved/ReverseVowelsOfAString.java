package com.leetcode.solved;

public class ReverseVowelsOfAString {
	private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c== 'i' || c =='o' || c == 'u') return true;
        c = (char)(c + 32);
        if(c == 'a' || c == 'e' || c== 'i' || c =='o' || c == 'u') return true;
        return false;
    }
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1) return s;
    
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length-1;
        
        while(i < j){
            if(!isVowel(array[i]))i++;
            else if(!isVowel(array[j]))j--;
            else{
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        
        return String.valueOf(array);
    }
}
