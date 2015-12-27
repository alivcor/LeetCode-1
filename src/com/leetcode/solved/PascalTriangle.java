package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> listPascal = new ArrayList<List<Integer>>();
		if(numRows == 0) return listPascal;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		listPascal.add(list);
		
		for(int i = 1; i <= numRows-1;i++){
			list = new ArrayList<>();
			list.add(1);
			List<Integer> prevList = listPascal.get(i-1);
			for(int j = 0; j <prevList.size() - 1; j++){
				list.add(prevList.get(j)+prevList.get(j+1));
			}
			list.add(1);
			listPascal.add(list);
		}
		
		return listPascal;
    }
	public static void main(String[] args) {
		System.out.println(generate(10));

	}

}
