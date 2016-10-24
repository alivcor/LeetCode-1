package com.leetcode.solved;

public class ID408_ValidWordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || word.length() == 0) return (abbr == null || abbr.length() == 0);
        
        int wIndex = 0;
        int aIndex = 0;
        int count = 0;
        while(wIndex < word.length() && aIndex < abbr.length()){
            if(word.charAt(wIndex) == abbr.charAt(aIndex)){
                wIndex++; aIndex++;
            }else if(!Character.isDigit(abbr.charAt(aIndex)) || abbr.charAt(aIndex) == '0') return false;
            else{
                while(aIndex < abbr.length() && Character.isDigit(abbr.charAt(aIndex))){
                    count = count*10 + (abbr.charAt(aIndex++) - '0'); 
                }
                wIndex += count;
                count = 0;
            }
        }
        
        return (wIndex == word.length() && aIndex == abbr.length());
        
    }

}
