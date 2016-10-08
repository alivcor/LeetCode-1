package com.leetcode.solved;

public class NthDigit {
	public static int findNthDigit(int n) {
        int length = 1;
        long count = 9;
        int start = 1;
        while(n > length*count){
            n -= length*count;
            length += 1;
            count *= 10;
            start *= 10;
        }
        //length of number where Nth digit is from
        start += (n-1)/length;
        //find actual number 
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n-1)%length));
        
    }
	
	public static void main(String[] args){
		System.out.println(findNthDigit(2147483647));
	}

}
