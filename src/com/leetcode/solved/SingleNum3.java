package com.leetcode.solved;

public class SingleNum3 {
	
	public static int[] singleNumber(int[] nums) {
        
        int allXOR = 0;
        int posXOR = 0;
        int negXOR = 0;
        int isNeg = 1;
        for(int element : nums){
            if(element > 0){
            	posXOR ^= element;
            }else{
            	negXOR ^= (element*-1);
            }
        }
        
        if(posXOR == 0){
        	allXOR = negXOR;
        	isNeg = -1;
        }else if(negXOR == 0){
        	allXOR = posXOR;
        }else{
        	int result[] = new int[2];
            result[0] = posXOR;
            result[1] = negXOR*-1;
            return result;
            
        }
        
        //allXOR would contain the XOR of two unrepeated numbers.
        int setBit = 0;
        int temp = allXOR;
        while(temp % 2 == 0){
        	temp/=2;
            setBit++;
        }
        
        //setBits contain the right shift for the first set bit.
        
        int limitedXOR = 0;
        for(int element : nums){
        	if(element < 0) element = element * -1;
            if((element >> setBit)%2 == 1){
                limitedXOR ^= element;
            }
        }
        
        int result[] = new int[2];
        result[0] = limitedXOR*isNeg;
        result[1] = (allXOR^limitedXOR)*isNeg;
        
        return result;
    }
	public static void main(String[] args) {
		int array[] = {-1,-2};
		
		singleNumber(array);

	}

}
