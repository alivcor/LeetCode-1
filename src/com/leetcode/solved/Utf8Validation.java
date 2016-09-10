package com.leetcode.solved;

public class Utf8Validation {

	private static int countBytes(int value){
        int mask = 7;
        int count = 0;
        while((value&(1<<mask)) != 0){
            count++;
            mask--;
        }
        
        return count;
    }
    
    private static boolean isValid(int val){
        int mask = (1<<7)|(1<<6);
        return (val&mask) == (1<<7);
    }
    public static boolean validUtf8(int[] data) {
        if(data == null || data.length == 0) return true;
        
        int index = 0;
        while(index < data.length){
            int countBytes = countBytes(data[index]);
            if(countBytes == 0) {
                index++;
                continue;
            }
            countBytes--;//we need N-1 following values.
            if(index + countBytes >= data.length || countBytes == 0) return false;
            
            int curIndex = index+1;
            while(curIndex < countBytes + index + 1){
                if(!isValid(data[curIndex++])) return false;
            }
            index = curIndex;
        }
        
        return true;
    }
	public static void main(String[] args) {
		System.out.println(validUtf8(new int[]{197,130,1,235,140,4}));

	}

}
