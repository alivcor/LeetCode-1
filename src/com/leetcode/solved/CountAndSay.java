package com.leetcode.solved;

public class CountAndSay {
	public String countAndSay(int n) {
        if(n == 0) return "";
        StringBuilder result = new StringBuilder("1");
        for(int i = 1; i < n; i++){
            StringBuilder current = new StringBuilder();
            result.append("X");
            int count = 1;
            for(int j = 1; j < result.length(); j++){
                if(result.charAt(j) == result.charAt(j-1)) count++;
                else {
                    current.append(count + "" + result.charAt(j-1));
                    count = 1;
                }
            }
            result = current;
        }
        return result.toString();
    }
}
