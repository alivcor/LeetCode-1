package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
	class TrieNode{
        String word;
        TrieNode next[] = new TrieNode[26];
    }
    
    private TrieNode addValues(String[] words){
        TrieNode root = new TrieNode();
        for(String curWrd : words){
            TrieNode cur = root;
            for(char c : curWrd.toCharArray()){
                if(cur.next[c - 'a'] == null) cur.next[c - 'a'] = new TrieNode();
                cur = cur.next[c - 'a'];
            }
            cur.word = curWrd;
        }
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0 || board[0].length == 0
            || words == null || words.length == 0) return Collections.emptyList();
            
        Set<String> result = new HashSet<>();
        TrieNode root = addValues(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                findWord(board, i, j, root, result);
            }
        }
        return new ArrayList(result);
    }
    
    private void findWord(char[][] board,int x, int y, TrieNode root, Set<String> result){
        if(root == null || x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] < 'a' || board[x][y] > 'z') return;
        char c = board[x][y];
        root = root.next[c - 'a'];
        if(root == null) return;
        
        if(root.word != null){
            result.add(root.word);
            root.word = null;
        }
        
        board[x][y] = (char)(((int)board[x][y])^255);
        findWord(board, x+1, y, root, result);
        findWord(board, x, y-1, root, result);
        findWord(board, x-1, y, root, result);
        findWord(board, x, y+1, root, result);
        board[x][y] = (char)(((int)board[x][y])^255);
    }

}
