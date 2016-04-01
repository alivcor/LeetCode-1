package com.leetcode.solved;

class TrieNode {
    boolean isEnd;
    TrieNode[] listChild = new TrieNode[26];
}

public class ImplementTriePrefixTree {
	private TrieNode root;

    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    private void addToTrie(TrieNode node, String word, int index){
		if(node.listChild[word.charAt(index) - 'a'] == null){
			node.listChild[word.charAt(index) - 'a'] = new TrieNode(); 
		}
		if(index == word.length() - 1){
			node.listChild[word.charAt(index) - 'a'].isEnd = true;
			return;
		}
		addToTrie(node.listChild[word.charAt(index) - 'a'], word, index+1);
	}
  
    // Inserts a word into the trie.
    public void insert(String word) {
        addToTrie(root, word, 0);
    }
    
    private boolean search(TrieNode node, String word, int index,boolean startWith){
    	if(node == null) return false;
    	if(index == word.length()) return startWith|node.isEnd;
    	return search(node.listChild[word.charAt(index) - 'a'], word, index + 1,startWith);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
         if(word == null || word.length() == 0) return true;
         return search(root, word, 0,false);
    }

    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) return true;
         return search(root, prefix, 0,true);
    }
    
    public static void main(String[] args){
    	ImplementTriePrefixTree trie = new ImplementTriePrefixTree();
    	trie.insert("aman");
    	trie.insert("amanr");
    	System.out.println(trie.search("aman"));
    	System.out.println(trie.search("am"));
    	System.out.println(trie.startsWith("aman"));
    	System.out.println(trie.startsWith(""));
    	
    }
}