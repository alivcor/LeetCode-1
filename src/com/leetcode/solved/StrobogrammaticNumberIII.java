package com.leetcode.solved;


public class StrobogrammaticNumberIII {
	int count = 0;
    char[][] array = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    public int strobogrammaticInRange(String low, String high) {
        for(int i = low.length(); i <= high.length(); i++){
            countNum(new char[i],0,i-1,low,high);
        }
        return count;
    }
    
    private void countNum(char[] number, int left, int right, String low, String high){
        if(left > right){
            String valNum = new String(number);
            if(valNum.length() == low.length() && valNum.compareTo(low) < 0) return;
            if(valNum.length() == high.length() && valNum.compareTo(high) > 0) return;
            count++;
            return;
        }
        
        for(char[] pair : array){
            number[left] = pair[0];
            number[right] = pair[1];
            if(number.length != 1 && number[0] == '0')continue;
            if(left == right && pair[0] != pair[1])continue;
            countNum(number, left+1, right-1, low, high);
        }
    }

}
