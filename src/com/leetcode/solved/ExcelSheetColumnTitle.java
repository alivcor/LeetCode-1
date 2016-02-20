package com.leetcode.solved;

public class ExcelSheetColumnTitle {

	public static String convertToTitle(int n) {
		return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(52));
		System.out.println(convertToTitle(27));
		System.out.println(convertToTitle(676*26));

	}
}
