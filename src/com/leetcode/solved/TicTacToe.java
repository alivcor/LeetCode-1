package com.leetcode.solved;
public class TicTacToe {

    int[] moveVal = {0,1,2};
    int board[][];
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if(hasWon(board,row,col,player)) return player;
        return 0;
    }
    
    private boolean hasWon(int[][] board, int row, int col, int playChar){
        boolean colWin = true;
        boolean rowWin = true;
        boolean diaWin = true;
        boolean revDia = true;
        for(int i = 0; i < board.length; i++){
            if(rowWin && board[row][i] != playChar) rowWin = false;
            if(colWin && board[i][col] != playChar) colWin = false;
            if(diaWin && board[i][i] != playChar) diaWin = false;
            if(revDia && board[i][board.length - i - 1] != playChar) revDia = false;
            if(!(colWin || rowWin || diaWin || revDia)) return false;
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */