package com.leetcode.solved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	static class Result{
		String word;
		int distance;
		public Result(String word, int distance) {
			super();
			this.word = word;
			this.distance = distance;
		}
		
	}
    public static int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {

		Queue<Result> queue = new LinkedList<>();
        
        queue.add(new Result(beginWord, 1));
        Set<String> alreadyUsed = new HashSet<>();
        while(!queue.isEmpty()){
        	Result topNode = queue.poll();
        	if(topNode.word.equalsIgnoreCase(endWord)) return topNode.distance;
        	for(int i = 0; i < topNode.word.length(); i++){
        		StringBuilder newWord = new StringBuilder(topNode.word);
        		for(char c = 'a'; c <= 'z'; c++){
        			if(topNode.word.charAt(i) == c) continue;
        			newWord.setCharAt(i, c);
        			String newWordString = newWord.toString();
        			if(!alreadyUsed.contains(newWordString) && wordList.contains(newWordString)){
        				queue.add(new Result(newWordString, topNode.distance + 1));
        				alreadyUsed.add(newWordString);
        			}
        		}
        	}
        }
        
        return 0;

    }
}
