package com.leetcode.tried;

import java.util.HashMap;

public class DistinctSubsequences {

	
	public static int numDistinctRecur(String s, String t) {
		
		if(s.length() < t.length()) return 0;
		if(t.length() == 0) return 1;
		
		if(s.charAt(0) == t.charAt(0)){
			return (numDistinctRecur(s.substring(1), t.substring(1)) + numDistinctRecur(s.substring(1), t));
		}
		
		return numDistinctRecur(s.substring(1), t);
		
    }
	
	static HashMap<String, Integer> data = new HashMap<>();
	public static int numDistinct(String s, String t){
		if(s.length() < t.length()) return 0;
		return numDistinct(s, t, 0, 0);
	}
	public static int numDistinct(String s, String t, int sindex, int tindex){
		
		if(sindex < tindex) return 0;
		if(tindex == t.length()) return 1;

		if(s.length() == sindex) return 0;
		
		
		String s1t1 = (sindex+1) + " " + (tindex+1);
		String s1t0 = (sindex+1) +" "+ tindex;
		
		if(!data.containsKey(s1t1))
			data.put(s1t1,numDistinct(s, t,sindex+1,tindex+1));
		
		if(!data.containsKey(s1t0))
			data.put(s1t0,numDistinct(s, t,sindex+1,tindex));
		
		if(s.charAt(sindex) == t.charAt(tindex)){
			return data.get(s1t1) + data.get(s1t0);
		}
		
		return  data.get(s1t0);
		
	}
	public static int numDistinctDP(String s, String t){
		
		if(s.length() < t.length()) return 0;
		int data[][] = new int[s.length()+1][t.length()+1];
		
		for(int i = 0; i <= s.length(); i++)
			data[i][0] = 1;
		
		
		for(int i = 1; i <= s.length(); i++){
			for(int j = i; j <= t.length(); j++){
				if(s.charAt(i-1) == s.charAt(j-1)){
					data[i][j] = data[i-1][j] + data[i-1][j];
				}else{
					data[i][j] = data[i-1][j-1];
				}
			}
		}
		
		return data[s.length()][t.length()];
	}
	public static void main(String[] args) {
		System.out.println(numDistinct("ccc", "c"));
		//System.out.println(numDistinctDP("abbbi", "abbi"));

	}

}
