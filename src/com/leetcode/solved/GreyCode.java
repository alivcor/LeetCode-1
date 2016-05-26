package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GreyCode {
	
	private static class Result{
		String value;
		boolean isLeft = false;
		public Result(String value, boolean isLeft) {
			super();
			this.value = value;
			this.isLeft = isLeft;
		}
		
	}
	public static List<Integer> grayCode(int n) {
		List<Integer> listNums = new ArrayList<Integer>();
		if(n == 0) {
			listNums.add(0);
			return listNums;
		}
		Stack<Result> stack = new Stack<>();
		stack.add(new Result("$", true));
		
		while(!stack.isEmpty()){
			Result top = stack.pop();
			if(top.value.length() == n + 1) {
				listNums.add(Integer.parseInt(top.value.substring(1), 2));
				continue;
			}
			if(top.isLeft){
				stack.add(new Result(top.value + "0", true));
				stack.add(new Result(top.value + "1", false));
			}else{
				stack.add(new Result(top.value + "1", true));
				stack.add(new Result(top.value + "0", false));
				
			}
		}
		Collections.reverse(listNums);
		return listNums;
    }

	public static void main(String[] args) {
		System.out.println(grayCode(3));

	}

}
