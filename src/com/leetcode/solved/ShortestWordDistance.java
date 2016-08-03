package com.leetcode.solved;

public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
        int w1Index = -1;
        int w2Index = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(word1.equals(words[i])){
                if(w2Index != -1) minDist = (minDist > (i - w2Index)) ? i - w2Index : minDist;
                w1Index = i;
            }
            else if(word2.equals(words[i])){
                if(w1Index != -1) minDist = (minDist > (i - w1Index)) ? i - w1Index : minDist;
                w2Index = i;
            }
        }
        
        return minDist;
    }
}
