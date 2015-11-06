package com.leetcode.tried;

public class ContainerWithMostWater {

	public static int maxAreaBruteForce(int[] height) {
        
		int maxArea = Integer.MIN_VALUE;
		for(int i = 0; i < height.length - 1; i++){
			for(int j = i+1; j < height.length; j++){
				maxArea = (maxArea > (j-i)*Integer.min(height[i], height[j])) ? 
						maxArea : (j-i)*Integer.min(height[i], height[j]);
			}
		}
		
		return maxArea;
    }
	/*
	 * Initially we assume the max area is between the first and the last index.
	 * Max area is the product of Min(two bars)*distance between them.
	 * We know that the distance between the bars would only decrease.
	 * So at each point in time, we would increment/decrement the index of smaller of two numbers.
	 * This might help push the min value higher.  
	 */
	public static int maxArea(int[] height) {
        
		if(height == null || height.length == 0 || height.length == 1) 
        	return 0;
        
		int globalMaxArea = Integer.min(height[0],height[height.length-1])*(height.length-1);
		int indexB = height.length-1;
		int indexF = 0;
		
		while(indexF < indexB){
			if(height[indexF] < height[indexB]){
				int currF = indexF + 1;
				while(height[currF] < height[indexF] && currF < indexB){
					currF++;
				}
				indexF = currF;
			}else{
				int currB = indexB - 1;
				while(height[currB] < height[indexB] && currB > indexF){
					currB--;
				}
				indexB = currB;
			}
			
			if(indexF < indexB && globalMaxArea < Integer.min(height[indexB],height[indexF]) * (indexB-indexF)){
				globalMaxArea = Integer.min(height[indexB],height[indexF]) * (indexB-indexF);
			}
			
		}
		
		return globalMaxArea;
    }
	
	public static void main(String[] args) {
		int[] height = {5,17,42,6,33,1,7};
		System.out.println(maxArea(height));

	}

}
