package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	
	public static List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		ip(s, new StringBuilder(), 4, result);
		return result;
    }
	
	public static void ip(String input, StringBuilder output, int count, List<String> result){
		if(input.length() > 3*count || input.length() < count) return;
		if(input.length() == 0 && count == 0) {
			result.add(output.substring(1));
			return;
		}
		if(input.length() == 0 || count == 0) return;
		
		if(input.charAt(0) == '0'){
			output.append(".0");
			ip(input.substring(1), output, count - 1, result);
			return;
		}
		int index = 1;
		while(input.length() >= index && Integer.parseInt(input.substring(0, index)) <= 255){
			ip(input.substring(index), new StringBuilder(output + "." + input.substring(0, index)), count-1, result);
			index++;
		}
	}

}
