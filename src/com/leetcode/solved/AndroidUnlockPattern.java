package com.leetcode.solved;

public class AndroidUnlockPattern {
	boolean[] used = new boolean[9];
    private boolean isValidMove(int cur, int pre){
        //If the number is used initially return false
        if(used[cur]) return false;
        //If its the first number 
        if(pre == -1) return true;
        //knight move or adjacent cells
        if((cur + pre)%2 == 1) return true;
        // indexes are at both end of the diagonals for example 0,0, and 8,8          
        int mid = (cur + pre)/2;
        if (mid == 4)
            return used[mid];
        // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and //1,1
        if ((cur%3 != pre%3) && (cur/3 != pre/3)) {
            return true;
        }
        // all other cells which are not adjacent
        return used[mid];
    }
    public int numberOfPatterns(int m, int n) {
        int count = 0;
        for(int i = m; i <= n; i++) count += countPat(-1,i);
        
        return count;
    }
    
    private int countPat(int prev, int len){
        if(len == 0) return 1;
        
        int count = 0;
        for(int i = 0; i < 9; i++){
            if(!isValidMove(i,prev)) continue;
            used[i] = true;
            count += countPat(i,len-1);
            used[i] = false;
        }
        
        return count;
    }

}
