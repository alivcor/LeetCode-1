package com.leetcode.solved;

import java.util.Arrays;

public class ID455_AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length == 0) return 0;
        if(s == null || s.length == 0) return 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        int indexg = 0;
        int indexs = 0;
        int count = 0;
        while(indexg < g.length && indexs < s.length){
            if(g[indexg] <= s[indexs]){
                count++;
                indexg++;
                indexs++;
            }else indexs++;
        }
        
        return count;
    }

}
