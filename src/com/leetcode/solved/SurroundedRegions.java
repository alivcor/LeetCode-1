package com.leetcode.solved;

import java.util.Stack;

public class SurroundedRegions {
	public static void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == 'O') solve(board,row,0);
            if(board[row][board[0].length-1] == 'O') solve(board,row,board[0].length-1);
        }
        
        for(int col = 0; col < board[0].length; col++){
            if(board[0][col] == 'O') solve(board,0,col);
            if(board[board.length-1][col] == 'O') solve(board,board.length-1,col);
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'I') board[i][j] = 'O';
            }
        }
    }
    
    private static void solve(char[][] board, int i, int j){
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{i,j});
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            if(top[0] < 0 || top[1] < 0 || top[0] >= board.length || top[1] >= board[0].length)continue;
            if(board[top[0]][top[1]] == 'O'){
                stack.push(new int[]{top[0]+1, top[1]});
                stack.push(new int[]{top[0], top[1]+1});
                stack.push(new int[]{top[0]-1, top[1]});
                stack.push(new int[]{top[0], top[1]-1});
                board[top[0]][top[1]] = 'I';
            }
        }

    }

}
