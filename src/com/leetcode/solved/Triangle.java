package com.leetcode.solved;

import java.util.List;

public class Triangle {

	/**Approach this question in the Dynamic Programming way.
	 * Start from the penultimate row and update the value by adding 
	 * minimum of left down/ or right down to it.
	 * Repeat this till we reach the first row.
	 * Return the value
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
        
		if(triangle == null || triangle.size() == 0) return 0;
        for(int i = triangle.size() - 2; i >= 0; i--){
        	for(int j = 0; j < triangle.get(i).size(); j++){
        		triangle.get(i).set(j, triangle.get(i).get(j) +
        				Integer.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
        	}
        }
        
        return triangle.get(0).get(0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
