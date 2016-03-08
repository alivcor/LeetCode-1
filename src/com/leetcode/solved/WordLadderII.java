package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	static class Node{
		String word;
		int level;
		Node parent;
		Node(String word, int level, Node parent){
			this.word = word;
			this.level = level;
			this.parent = parent;
		}
		@Override
		public String toString() {
			return "Node [word=" + word + ", level=" + level + ", parent="
					+ parent + "]";
		}
		
		
		
	}
	public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)) return Collections.EMPTY_LIST;
        
        Queue<Node> queue = new LinkedList<Node>();
        Map<String,Integer> visitMap = new HashMap<String, Integer>();
        List<Node> result = new ArrayList<>();
        int minPLength = Integer.MAX_VALUE;
        
        queue.add(new Node(endWord, 0,null));
        for(String word : wordList) visitMap.put(word, Integer.MAX_VALUE);
        visitMap.put(endWord, 0);
        
        while(!queue.isEmpty()){
        	Node topNode = queue.poll();
        	if(topNode.level > minPLength) break;
        	if(topNode.word.equals(beginWord) && topNode.level <= minPLength){
        		result.add(topNode);
        		minPLength = topNode.level;
        		continue;
        	}
        	
        	for(int i = 0; i < topNode.word.length(); i++){
        		StringBuilder newWord = new StringBuilder(topNode.word);
        		for(char c = 'a'; c <= 'z'; c++){
        			if(topNode.word.charAt(i) == c) continue;
        			newWord.setCharAt(i, c);
        			String newWordString = newWord.toString();
        			if(wordList.contains(newWordString) && topNode.level < visitMap.get(newWordString)){
        				queue.add(new Node(newWordString, topNode.level + 1, topNode));
        				visitMap.put(newWordString, topNode.level + 1);
        			}
        		}
        	}
        	
        }
             
        List<List<String>> pathList = new ArrayList();
        for(Node node : result){
        	List<String> path = new ArrayList<>();
        	while(node != null){
        		path.add(node.word);
        		node = node.parent;
        	}
        	pathList.add(path);
        }
        return pathList;
        
    }

	public static void main(String[] args) {
		
		//String elements[] = { "hot","cog","dog","tot","hog","hop","pot","dot"};
		String elements[] = { "ted","tex","red","tax","tad","den","rex","pee"};
		//String elements[] = { "hot","dog"};
	    Set set = new HashSet(Arrays.asList(elements));

	    System.out.println(findLadders("red", "tax", set));
		//System.out.println(findLadders("hot", "dog", set));

	}

}
