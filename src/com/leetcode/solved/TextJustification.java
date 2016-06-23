package com.leetcode.solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextJustification {
	public static List<String> fullJustify(String[] array, int maxLen){
		if(array  == null || array.length == 0) return Collections.emptyList();
		List<String> result = new ArrayList<>();
		if(array[0].length() == 0 && maxLen == 0){
			result.add("");
			return result;
		}
		
		int chaCount = 0;
		List<String> tempList = new ArrayList<>();
		
		for(int i = 0; i < array.length; i++){
			if(chaCount + array[i].length() > maxLen){
				result.add(doJustify(tempList, maxLen,chaCount - tempList.size()));
				tempList = new ArrayList<>();
				tempList.add(array[i]);
				chaCount = 1 + array[i].length();
			}else{
				tempList.add(array[i]);
				chaCount += 1 + array[i].length();
			}
		}
		if(tempList.size() != 0){
			StringBuilder lastLine = new StringBuilder();
			for(String wrd : tempList)lastLine.append(wrd + " ");
			lastLine.delete(lastLine.length()-1, lastLine.length());
			lastLine.append(getNSpaces(maxLen - lastLine.length()));
			result.add(lastLine.toString());
		}
		return result;
	}
	
	private static String getNSpaces(int n){
		return new String(new char[n]).replace("\0", " ");
	}
	private static String doJustify(List<String> line, int maxLen, int charCount){
		
		if(line == null || line.size() == 0) return "";
		StringBuilder result = new StringBuilder();
		if(line.size() == 1){
			result.append(line.get(0));
			result.append(getNSpaces(maxLen - result.length()));
			return result.toString();
		}
		int spacePerWrd = (maxLen - charCount)/(line.size() - 1);
		int additionalAdj = (maxLen - charCount) - spacePerWrd*(line.size() - 1);
		String spaceBW = getNSpaces(spacePerWrd);
		int i;
		for(i = 0; i < line.size() - 1; i++){
			result.append(line.get(i));
			result.append(spaceBW);
			if(i < additionalAdj) result.append(" ");
		}
		result.append(line.get(i));
		return result.toString();
	}

}
