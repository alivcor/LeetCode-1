package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequences {

	Map<String, Integer> dpmp = new HashMap<>();
	public int numDistinct(String s,String t) {
		dpmp = new HashMap<>();
		if(s == null || t == null) return 0;
		return numDistUtil(s, 0, t, 0);
    }
	
	private  int numDistUtil(String s, int is, String t, int it){
		if(it == t.length()) return 1;
		if(s.length() - is < t.length() - it) return 0;
		
		String s_t = is + " " + it;
		if(dpmp.containsKey(s_t)) return dpmp.get(s_t);
		if(s.charAt(is) == t.charAt(it)) dpmp.put(s_t, numDistUtil(s, is+1, t, it+1) + numDistUtil(s,is+1,t,it));
		else dpmp.put(s_t, numDistUtil(s,is+1,t,it));
		
		return dpmp.get(s_t);
	}
	
	public int numDistinctItr(String s, String t){
		if(s == null || t == null) return 0;
		int dpArray[][] = new int[s.length() + 1][t.length() + 1];
		for(int i = 0; i <= s.length(); i++) dpArray[i][0] = 1;
		
		for(int i = 1; i <= s.length(); i++){
			for(int j = 1; j <= t.length(); j++){
				if(s.charAt(i-1) == t.charAt(j-1)){
					dpArray[i][j] = dpArray[i-1][j-1] + dpArray[i-1][j];
				}else dpArray[i][j] = dpArray[i-1][j];
			}
		}
		return dpArray[s.length()][t.length()];
	}
	public static void main(String[] args) {
		//System.out.println(numDistinct("", ""));
		DistinctSubsequences ds = new DistinctSubsequences();
		System.out.println(ds.numDistinctItr("ccccss", "cs"));
		System.out.println(ds.numDistinctItr("abbbii", "abbi"));

	}

}
