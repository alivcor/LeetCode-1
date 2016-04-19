package com.leetcode.solved;

public class GameOfLife {

	private int getNextState(int[][] board, int x, int y){
        int countLiveN = 0;
        if(x > 0) countLiveN += getOldState(board[x-1][y]);
        if(y > 0) countLiveN += getOldState(board[x][y-1]);
        if(x > 0 && y > 0) countLiveN += getOldState(board[x-1][y-1]);
        if(x < board.length - 1) countLiveN += getOldState(board[x+1][y]);
        if(y < board[0].length - 1) countLiveN += getOldState(board[x][y+1]);
        if(x < board.length - 1 && y < board[0].length - 1) countLiveN += getOldState(board[x+1][y+1]);
        if(x > 0 && y < board[0].length - 1) countLiveN += getOldState(board[x-1][y+1]);
        if(x < board.length - 1 && y > 0) countLiveN += getOldState(board[x+1][y-1]);
        
        return nextState(countLiveN, board[x][y]);
    }
    
    private int getOldState(int value){
        return value&1;
    }
    
    private int nextState(int liveNbrs, int currentState){
        if(liveNbrs < 2 && currentState == 1) return 0;
        if(liveNbrs <= 3 && currentState == 1) return 1;
        if(currentState == 1) return 0;
        if(currentState == 0 && liveNbrs == 3) return 1;
        return currentState;
    }
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = (getNextState(board,i,j)<<1)|board[i][j];
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = board[i][j]>>1;
            }
        }
        
        return;
    }
}
