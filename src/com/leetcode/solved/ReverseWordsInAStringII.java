package com.leetcode.solved;

public class ReverseWordsInAStringII {
	public void reverseWords(char[] s) {
        if(s == null || s.length == 0) return;
        int start = 0;
        reverse(s,0,s.length-1);
        
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(s,start,i-1);
                start = i+1;
            }    
        }
        
        reverse(s,start,s.length-1);
    }
    
    private void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
