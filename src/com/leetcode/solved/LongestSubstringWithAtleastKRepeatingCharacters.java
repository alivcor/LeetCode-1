package com.leetcode.solved;

public class LongestSubstringWithAtleastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        char[] count = new char[26];
        char minCount = s.charAt(0);
        for(int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        for(int i = 0; i < 26; i++) if(count[i] > 0 && count[i] < count[minCount-'a']) minCount = (char)(i + 'a');
        
        System.out.println(minCount);
        if(count[minCount - 97] >= k) return s.length();
        String[] array = s.split(minCount+"");
        int maxInt = 0;
        for(int i = 0; i < array.length; i++){
            maxInt = Integer.max(maxInt,longestSubstring(array[i],k));
        }
        return maxInt;
    }
}
