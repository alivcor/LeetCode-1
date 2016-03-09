package com.leetcode.solved;

public class CompareVersionNumbers {

	public static int compareVersion(String version1, String version2) {

		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		int length = Integer.max(ver1.length, ver2.length);
		for(int i = 0; i < length; i++){
			int val1 = (i < ver1.length) ? Integer.parseInt(ver1[i]) : 0;
			int val2 = (i < ver2.length) ? Integer.parseInt(ver2[i]) : 0;
			if(val1 == val2) continue;
			return (val1 > val2) ? 1 : -1;
		}
		return 0;
    }
	public static void main(String[] args) {
		System.out.println(compareVersion("01", "1"));
		System.out.println(compareVersion("1.2.3", "1.2.2"));
		System.out.println(compareVersion("1.2.3", "1.2"));
		System.out.println(compareVersion("1.1.3", "1.2"));

	}

}
