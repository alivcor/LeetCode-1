package com.leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
	// Encodes a list of strings to a single string.
	public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }
    
    
    public static void main(String args[]){
    	List<String> list = new ArrayList<>();
    	list.add("");
    	
    	System.out.println(decode(encode(list)));
    }

}
