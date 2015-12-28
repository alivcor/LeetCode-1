package com.leetcode.solved;

import java.util.HashSet;

public class ValidSudoko {

	private boolean verifyRowsColumns(char[][] board){
		for (int i = 0; i < 9; i++){
			HashSet<Character> rowSet = new HashSet<>();
			HashSet<Character> colSet = new HashSet<>();
			for(int j = 0; j < 9;j++){
				if(board[i][j] != '.' && rowSet.contains(board[i][j]))
						return false;
				if(board[j][i] != '.' && colSet.contains(board[j][i]))
					return false;
				rowSet.add(board[i][j]);
				colSet.add(board[j][i]);
			}
		}
		
		return true;
	}
	
	private boolean verifyBoxes(char[][] board){
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				HashSet<Character> boxSet = new HashSet<>();
				for(int l = 3*i; l < 3*i+3; l++){
					for(int m = 3*j; m<3*j+3 ;m++){
						if(board[l][m] != '.' && boxSet.contains(board[l][m]))
							return false;
						boxSet.add(board[l][m]);
					}
				}
			}
		}
		return true;
	}
	public boolean isValidSudoku(char[][] board) {
		return (verifyRowsColumns(board) && verifyBoxes(board));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
