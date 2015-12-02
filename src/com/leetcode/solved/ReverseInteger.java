package com.leetcode.solved;

public class ReverseInteger {

	public static int reverse(int x) {
        
        int sign = (x > 0) ? 1 : -1;
        int newVal = 0;
        while(x != 0){
            if((sign == 1 && newVal > (Integer.MAX_VALUE-x%10)/10) || (sign == -1 && newVal < (Integer.MIN_VALUE - x%10)/10)){
                return 0;
            }
            newVal = newVal*10 + x%10;
            x = x/10;
        }
        
        return newVal;
        
    }
	public static void main(String[] args) {
		System.out.println(reverse(1234));
		System.out.println(reverse(-1204));
		System.out.println(reverse(Integer.MAX_VALUE - 10));
		System.out.println(reverse(Integer.MIN_VALUE + 100));

	}

}
