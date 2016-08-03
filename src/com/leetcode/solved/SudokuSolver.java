package com.leetcode.solved;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        if(board == null) return;
        solveSudokuUtil(board);
        
    }
    public boolean solveSudokuUtil(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char val = '1'; val <= '9'; val++){
                        if(isValid(board,i,j,val)){
                            board[i][j] = val;
                            if(solveSudokuUtil(board))return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    
    private boolean isValid(char[][] board, int row, int col, char c){
        
        //check row
        for(int i = 0; i < 9; i++) if(board[row][i] == c) return false;
        //check column
        for(int i = 0; i < 9; i++) if(board[i][col] == c) return false;
        //check boxes
        for(int i = row/3*3; i < row/3*3 + 3; i++)
            for(int j = col/3*3; j < col/3*3 + 3; j++)
                if(board[i][j] == c) return false;
        
        return true;
    }
}
