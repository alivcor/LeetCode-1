package com.leetcode.solved;


public class SingleNumber2 {
	
	public static int singleNumber(int[] array){
		if(array == null || array.length == 0) return -1;
		
		int t1 = array[0];
		int t2 = 0;
		int t3 = 0;
		
		for(int i = 1; i < array.length; i++){
			//Update T2 to add additional bits from T1 and current element.
			t2 = t2 | (t1&array[i]);
			t1 = t1^array[i];
			//T3 would be the bits where both T1 and T2 would be set.
			t3 = t1&t2;
			t1 = t1&~t3;
			t2 = t2&~t3;
		}
		
		return t1;
		
	}

	public static void main(String[] args) {
		int[] array = {1,2,1,1,2,2,4};
		System.out.println(singleNumber(array));
		

	}

}
