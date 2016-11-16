package com.leetcode.solved;

public class ID459_RepeatedSubstringPattern {
private int[] kmpPreprocessing(String str){
        
        int[] array = new int[str.length()];
        int index = 1;
        int prev = 0;
        
        while(index < str.length()){
            if(str.charAt(index) == str.charAt(prev)){
                array[index] = ++prev;
                index++;
            }else{
                if(prev == 0){
                    array[index++] = 0;
                }else{
                    prev = array[prev-1];
                }
            }
        }
        
        return array;
        
    }
    public boolean repeatedSubstringPattern(String str) {
        if(str == null || str.length() == 0) return true;
        
        int[] preprocess = kmpPreprocessing(str);
        int matchLen = preprocess[str.length() - 1];
        int len = str.length();
        return (matchLen > 0 && len%(len - matchLen) == 0);
    }

}
