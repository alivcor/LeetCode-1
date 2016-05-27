package com.leetcode.solved;

public class CountNSay {
	
	public static String countAndSay(int n) {
		StringBuilder sb = new StringBuilder();
		if(n == 0) return sb.toString();
		
        sb.append("1X");
        for(int i = 0; i < n-1; i++){
        	StringBuilder updatedSb = new StringBuilder();
        	int count = 1;
        	for(int j = 1; j < sb.length(); j++){
        		if(sb.charAt(j) == sb.charAt(j-1))count++;
        		else{
        			updatedSb.append(count + "" + sb.charAt(j-1));
        			count = 1;
        		}
        	}
        	updatedSb.append("X");
        	sb = updatedSb;
        }
        
        return sb.substring(0,sb.length()-1);    
    }

	public static void main(String[] args) {
		System.out.println(countAndSay(5));

	}

}
