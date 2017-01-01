package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class ID474_OnesAndZeros {
	
	/*
    Solution using DP.
    Have a DP array, where dp[i][j] contains the count of maximum strings that can be included by using i 0s and j 1s
    
    For each of the strings, 
        start with i = m and for each value of i and j upto the count of zeros and ones update the value.
        The above is the inclusion phase and exclusion phase is already handled by the Math.max thing.
    */
    private int[] count(String s){
        int[] pair = new int[2];
        for(int i = 0; i < s.length(); i++){
            pair[s.charAt(i) - '0']++;
        }
        
        return pair;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String s: strs){
            int[] pairs = count(s);
            for(int i = m; i >= pairs[0]; i--){
                for(int j = n; j >= pairs[1]; j--){
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - pairs[0]][j - pairs[1]]);
                }
            }
        }
        
        return dp[m][n];
    }
	
	
	
	
	//Solution1. TLE
	Map<String,Integer> map = new HashMap<>();
    Map<String,Integer> dp = new HashMap<>();
    public int findMaxFormTLE(String[] strs, int m, int n) {
        if(strs == null) return 0;
        for(int i = 0; i < strs.length; i++) map.put(strs[i], countSetB(strs[i]));
        return findMax(strs, 0, m, n);
    }
    
    private int countSetB(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += (s.charAt(i) == '1') ? 1 : 0;
        }
        
        return count;
    }
    private int findMax(String[] strs, int index, int m, int n) {
        if(index == strs.length || (m == 0 && n == 0)) return 0;
        
        String key = index + "_" + m + "_" + n;
        if(dp.containsKey(key)) return dp.get(key);
        
        //exclude above
        int ex = findMax(strs, index + 1, m, n);
        
        //include above
        int countS = map.get(strs[index]);
        int in = 0;
        if(n >= countS && m >= strs[index].length() - countS){
            in = 1 + findMax(strs, index + 1, m - strs[index].length() + countS, n - countS);
        }
        
        dp.put(key,Integer.max(ex,in));
        return dp.get(key);
    }

}
