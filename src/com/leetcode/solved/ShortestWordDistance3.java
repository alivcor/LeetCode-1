package com.leetcode.solved;

public class ShortestWordDistance3 {
	public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        if(word1.equals(word2)) return shortestSame(words,word1);
        return shortestDiff(words,word1,word2);
        
    }
    
    private int shortestDiff(String[] words, String word1, String word2){
        int minLength = Integer.MAX_VALUE;
        int indexW1 = -1;
        int indexW2 = -1;
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                if(indexW2 != -1) minLength = Integer.min(i - indexW2, minLength);
                indexW1 = i;
            }else if(words[i].equals(word2)){
                if(indexW1 != -1) minLength = Integer.min(i - indexW1, minLength);
                indexW2 = i;
            }
        }
        return minLength;
    }
    
    private int shortestSame(String[] words, String word){
        int minLength = Integer.MAX_VALUE;
        int prev = -1;
        for(int i = 0; i < words.length; i++){
            if(word.equals(words[i])){
                if(prev == -1) prev = i;
                else {
                    minLength = Integer.min(minLength,i-prev);
                    prev = i;
                }
            }
        }
        return minLength;
    }
}
