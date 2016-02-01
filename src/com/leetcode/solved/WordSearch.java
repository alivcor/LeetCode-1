package com.leetcode.solved;

public class WordSearch {

	 /** Floodfill
	 * @param board
	 * @param word
	 * @return
	 */
	public static boolean exist(char[][] board, String word) {
	        if(board == null || word == null || word.length() == 0) return false;
	        for(int i = 0; i < board.length; i++){
	            for(int j = 0; j < board[0].length; j++){
	                if(ifExist(word,0,board,i,j)) return true;
	            }
	        }
	        
	        return false;
	    }
	    
	    private static boolean ifExist(String word, int index, char[][] board,
	        int x, int y){
	        if(index == word.length()) return true;
	        if(x >= board.length || x < 0 || y >= board[0].length || y < 0) return false;
	        if(board[x][y] != word.charAt(index)) return false;
	        board[x][y] ^= 256;
	        boolean result =  (ifExist(word,index+1,board,x + 1, y) ||
	        ifExist(word,index+1,board,x - 1, y) ||
	        ifExist(word,index+1,board,x, y + 1) ||
	        ifExist(word,index+1,board,x, y - 1));
	        
	        board[x][y] ^= 256;
	        return result;
	    }
	public static void main(String[] args) {
		
		char[][] array = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(exist(array, "ABCCED"));

	}

}
