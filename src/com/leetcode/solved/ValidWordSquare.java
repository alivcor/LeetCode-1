package com.leetcode.solved;

public class ValidWordSquare {
	public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0) return true;
        int wordL = words.get(0).length();
        if(words.size() != wordL) return false;
        
        
        for(int i = 0; i < words.size(); i++){
            String curWord = words.get(i);
            if(words.size() < curWord.length()) return false;
            for(int j = 0; j < curWord.length(); j++){
                if(words.get(j).length() <= i || curWord.charAt(j) != words.get(j).charAt(i)) return false;
            }
        }
        
        return true;
    }

}
