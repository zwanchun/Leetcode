/*Valid Sudoku
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited=new boolean[9];
        
        //rows
        for(int i=0;i<9;i++){
            Arrays.fill(visited, false);
            for(int j=0;j<9;j++){
                if(!process(visited, board[i][j]))
                    return false;
            }
            
        }
        
        //columns
        for(int i=0;i<9;i++){
            Arrays.fill(visited,false);
            for(int j=0;j<9;j++){
                if(!process(visited,board[j][i]))
                    return false;
            }
        }
        
        //sub-board
        for(int i = 0; i<9; i+= 3){
            for(int j = 0; j<9; j+= 3){
                Arrays.fill(visited, false);
                for(int k = 0; k<9; k++){
                    if(!process(visited, board[i + k/3][ j + k%3]))
                        return false;                   
                }
            }
        }
        return true;
        
    }
        
    
    private boolean process(boolean[] visited, char digit){
        if(digit=='.') return true;
        int number=digit-'0';
        if(number<1||number>9||visited[number-1]) return false;
        visited[number-1]=true;
        return true;
    }
}
