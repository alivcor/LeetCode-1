package com.leetcode.solved;

public class ExcelSheetColumnNumber {

	/*
	 * Given a column title calculate column#. Starting with A = 1.
	 * Define two variables colNumber = to store the intermediate column numbers
	 * currentMul = Multiplicity factor.
	 * 
	 * Loop through the array, adding to the column number current char multiplied by multiplicity factor.
	 */
	public static int titleToNumber(String s) {
        int colNumber = 0;
        int currentMul = 1;
        for(int i = s.length()-1; i>=0; i--){
            colNumber += currentMul*(s.charAt(i) - 'A' + 1);
            currentMul *= 26;
        }
        
        return colNumber;
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("AAA"));
		System.out.println(titleToNumber("BA"));

	}

}
