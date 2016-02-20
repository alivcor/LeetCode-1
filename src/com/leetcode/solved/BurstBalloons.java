package com.leetcode.solved;

public class BurstBalloons {
	
	public static int maxCoins(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		
		int numC[] = new int[nums.length + 2];
		for(int i = 0; i < nums.length; i++){
			numC[i+1] = nums[i];
		}
		numC[0] = 1;
		numC[numC.length - 1] = 1;
		
		int scoreTable[][] = new int[numC.length][numC.length];
		
		
		for(int l = 1; l < numC.length; l++){
			for(int i = 1; i < (numC.length - l + 1); i++){
				int j = (i + l - 1);
				for(int k = i; k < j; k++){
					if(scoreTable[i][j] < (scoreTable[i][k] + scoreTable[k+1][j] + numC[i-1]*numC[j]*numC[k]))
						scoreTable[i][j] = (scoreTable[i][k] + scoreTable[k+1][j] + numC[i-1]*numC[j]*numC[k]);
					
				}
			}
		}
		
		return scoreTable[1][numC.length-1];
	}

	public static void main(String[] args) {
		int array[] = {3,1,5,8};
		System.out.println(maxCoins(array));

	}

}
