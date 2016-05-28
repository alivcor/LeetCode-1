package com.leetcode.solved;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class PermutationSequence {
	
	
	public static String getPermutation(int n, int k) {
		if(k == 0) return "";
		StringBuilder result = new StringBuilder();
		List<Integer> charList = new LinkedList<Integer>();
		IntStream.range(1, n+1).forEach(i -> charList.add(i));
		//CharList will have value from 1 to N-1
		
		int[] factorial = new int[n+1];
		factorial[0] = 1;
		IntStream.range(1, n + 1).forEach(i -> factorial[i] = i * factorial[i-1]);
		k -= 1;
		while(charList.size() > 0){
			int index = k/factorial[charList.size()-1];
			k = k - index * factorial[charList.size()-1];
			result.append(charList.get(index));
			charList.remove(index);
		}
		
		return result.toString();
    }

	public static void main(String[] args) {
		System.out.println(getPermutation(8, 8590));
//		IntStream.range(1, 6).forEach(i -> System.out.println(getPermutation(3, i)));
		

	}

}
