package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix){
		if(matrix == null ||  matrix.length == 0 || matrix[0].length == 0) return Collections.emptyList();
		int countRow = matrix.length;
		int countCol = matrix[0].length;
		
		List<Integer> result = new ArrayList<>();
		int curRowStart = 0;
		int curRowEnd = countRow - 1;
		int curColStart = 0;
		int curColEnd = countCol - 1;
		while(curColEnd >= curColStart && curRowEnd >= curRowStart){
			for(int i = curColStart; i <= curColEnd; i++) result.add(matrix[curRowStart][i]);
			for(int i = curRowStart + 1; i < curRowEnd; i++) result.add(matrix[i][curColEnd]);
			for(int i = curColEnd; i >= curColStart; i--)if(curRowEnd != curRowStart) result.add(matrix[curRowEnd][i]);
			for(int i = curRowEnd-1; i > curRowStart; i--)if(curColEnd != curColStart) result.add(matrix[i][curColStart]);
			curColEnd--;
			curColStart++;
			curRowEnd--;
			curRowStart++;
		}
		return result;
	}
}
