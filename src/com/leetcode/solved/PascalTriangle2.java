package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

	public static List<Integer> getRow(int numRows) {
		List<Integer> listPascal = new ArrayList<Integer>();
		listPascal.add(1);
		if(numRows == 0) return listPascal;
		
		for(int i = 1; i <= numRows;i++){
			List<Integer> list = new ArrayList<>();
			list.add(1);
			List<Integer> prevList = listPascal;
			for(int j = 0; j <prevList.size() - 1; j++){
				list.add(prevList.get(j)+prevList.get(j+1));
			}
			list.add(1);
			listPascal.clear();
			listPascal.addAll(list);
		}
		
		return listPascal;
    }
	public static void main(String[] args) {
		System.out.println(getRow(5));

	}

}
