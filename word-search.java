/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

/*http://www.cnblogs.com/yuzhangcmu/p/4040418.html
dfs
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
		
		if(board==null||word==null||word.length()==0||board.length==0||board[0].length==0) return false;
		
		int row=board.length;
		int col=board[0].length;
		
		for(int i=0;i<row;i++){
			
			for(int j=0;j<col;j++){
				if(dfs(board,i,j,0,word)){
					return true;
				}
			}
		}
		
		return false;
	
        
    }
	
	private boolean dfs(char[][] board, int i, int j, int wordindex, String word){
	    
	    int row=board.length;
		int col=board[0].length;
		
		if(wordindex>=word.length()) return true;
		if(i<0||i>=row||j<0||j>=col) return false;
		if(board[i][j]=='#') return false;
		if(word.charAt(wordindex)!=board[i][j]) return false;
		
	    char tmp = board[i][j];
        board[i][j] = '#';
		
		if(dfs(board, i+1, j, wordindex+1, word)){
			return true;
		}
		
		if(dfs(board, i-1, j, wordindex+1, word)){
			return true;
		}
		
		if(dfs(board, i, j+1, wordindex+1, word)){
			return true;
		}
		
		if(dfs(board, i, j-1, wordindex+1, word)){
			return true;
		}
		
		board[i][j]=tmp;
		
		return false;
		
	}
}
