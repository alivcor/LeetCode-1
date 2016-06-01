package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Candy {
	
	public static int candyWithmap(int[] ratings) {
		if(ratings == null || ratings.length <= 1)
			return (ratings == null || ratings.length == 0) ? 0 : 1;
		
		Map<Integer, Set<Integer>> ratIndex = new HashMap<>();
		for(int i = 0; i < ratings.length; i++){
			ratIndex.computeIfAbsent(ratings[i],val ->  new HashSet<Integer>()).add(i);
		}
		
		int[] candy = new int[ratings.length];
		List<Integer> ratingSet = new ArrayList<Integer>(ratIndex.keySet());
		Collections.sort(ratingSet);
		int sum = 0;
		for(Integer rating : ratingSet){
			for(int index : ratIndex.get(rating)){
				int maxNeighbor = (index == 0) ? 1 : 1 + candy[index-1];
				sum += candy[index] = Integer.max(maxNeighbor, (index == ratings.length - 1) ? 1 : 1 + candy[index+1]); 
				
			}
		}
		return sum;
	}

	public static int candy(int[] ratings) {
		if(ratings == null || ratings.length <= 1)
			return (ratings == null || ratings.length == 0) ? 0 : 1;
		
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		for(int i = 1; i < ratings.length; i++){
			if(ratings[i] > ratings[i-1]) candy[i] = 1 + candy[i-1];
		}
		for(int i = ratings.length-2; i >= 0; i--){
			if(ratings[i] > ratings[i+1]) candy[i] = Integer.max(candy[i],1 + candy[i+1]);
		}
		return Arrays.stream(candy).sum();
	}
	public static void main(String[] args) {
		int[] ratings = new int[20000];
		for(int i = 1; i <= 20000; i++) ratings[i-1] = i;
		System.out.println(candy(ratings));

	}

}
