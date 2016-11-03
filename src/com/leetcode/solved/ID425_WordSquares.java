package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ID425_WordSquares {
	
	
	class TrieNode{
        List<String> prefix;
        Map<Integer, TrieNode> children;
        public TrieNode(){
            children = new HashMap<Integer, ID425_WordSquares.TrieNode>();
            prefix = new ArrayList<>();
        }
		@Override
		public String toString() {
			return "TrieNode [prefix=" + prefix + ", children=" + children
					+ "]";
		}
		
        
    }
    TrieNode root = new TrieNode();
    public void add(String[] array){
        if(array == null) return;
        
        TrieNode current = root;
        for(String s : array){
            for(char c : s.toCharArray()){
                current.prefix.add(s);
                if(!current.children.containsKey(c - 'a')){
                    current.children.put(c - 'a',new TrieNode());
                }
                current = current.children.get(c - 'a');
            }
            current = root;
        }
    }
    
    private List<String> search(String prefix){
        TrieNode current = root;
        List<String> curList = root.prefix;
        for(char c : prefix.toCharArray()){
            current = current.children.get(c -  'a');
            if(current == null) return Collections.emptyList();
            curList = current.prefix;
        }
        
        return curList;
    }
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> wordSquares(String[] words) {
        if(words == null || words.length == 0) return result;
        add(words);
        search(words, 0, new ArrayList<>());
        return result;
    }
    
    private void search(String[] words, int index, List<String> current){
        if(index == words[0].length()){
            result.add(new ArrayList<>(current));
            return;
        }
        
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < index; i++){
            prefix.append(current.get(i).charAt(index));
        }
        
        List<String> prefixList = search(prefix.toString());
        for(String s : prefixList){
                current.add(s);
                search(words, index + 1, current);
                current.remove(current.size() - 1);
        }
    }

	public static void main(String[] args) {
		ID425_WordSquares o = new ID425_WordSquares();
		System.out.println(o.wordSquares(new String[]{"lead","lady","area","wall","ball"}));

	}

}
