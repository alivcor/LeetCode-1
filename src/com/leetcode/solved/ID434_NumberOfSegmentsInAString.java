package com.leetcode.solved;

public class ID434_NumberOfSegmentsInAString {
	public int countSegments(String s) {
        if(s == null || s.trim().length() == 0) return 0;
        return s.trim().split("\\s+").length;
    }
}
