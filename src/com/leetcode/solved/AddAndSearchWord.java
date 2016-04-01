package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWord {

	static class Trie{
		boolean isEnd;
		Trie[] listChild = new Trie[26];
	}
	
	private Trie dictionary = new Trie();
	private Map<String,Boolean> searchHash = new HashMap<>();;
	
	private void addToTrie(Trie node, String word, int index){
		if(node.listChild[word.charAt(index) - 'a'] == null){
			node.listChild[word.charAt(index) - 'a'] = new Trie(); 
		}
		if(index == word.length() - 1){
			node.listChild[word.charAt(index) - 'a'].isEnd = true;
			return;
		}
		addToTrie(node.listChild[word.charAt(index) - 'a'], word, index+1);
	}
  
    public void addWord(String word) {
        if(searchHash.get(word) != null && searchHash.get(word) == true)return;
        addToTrie(dictionary, word, 0);
        searchHash.put(word,true);
    }

    private boolean searchInTrie(Trie node, String word, int index){
    	if(node == null) return false;
    	if(index == word.length()) return node.isEnd;
    	
    	if(word.charAt(index) == '.'){
    		for(int i = 0; i < 26; i++){
    			if(node.listChild[i] != null &&
    					searchInTrie(node.listChild[i], word, index+1)) return true;
    		}
    		return false;
    	}
    	
    	return searchInTrie(node.listChild[word.charAt(index) - 'a'], word, index + 1);
    }
    public boolean search(String word) {
        if(word == null || word.length() == 0) return true;
        if(searchHash.get(word) == null){
            if(searchInTrie(dictionary, word, 0)){
                searchHash.put(word,true);
                return true;
            }
        }
        return (searchHash.get(word) != null && searchHash.get(word) == true) ? true : false;
    }    
    public static void main(String[] args){
    	AddAndSearchWord wd = new AddAndSearchWord();
    	wd.addWord("aman");
    	wd.addWord("ama");
    	wd.addWord("nam");
    	System.out.println(wd.search("aman"));
    	System.out.println(wd.search("ama"));
    	System.out.println(wd.search("amn"));
    	System.out.println(wd.search("nam"));
    	System.out.println(wd.search("..."));
    	System.out.println(wd.search(".man"));
    }
}
