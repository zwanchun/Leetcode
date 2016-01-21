/*Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        int n=grid.length, m=grid[0].length;
        int[][] path=new int[n][m];
        
        path[0][0]=grid[0][0];
        
        for(int i=1;i<m;i++){
            path[0][i]=path[0][i-1]+grid[0][i];
        }
        
        for(int i=1;i<n;i++){
            path[i][0]=path[i-1][0]+grid[i][0];
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                path[i][j]=Math.min(path[i-1][j],path[i][j-1])+grid[i][j];
            }
        }
        
        return path[n-1][m-1];
        
        
    }
}
