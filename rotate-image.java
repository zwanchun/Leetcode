/*Rotate Image
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

/*iterate half of the matrix, 
(i,j)->(j,n-1-i)
(j,n-1-i)->(n-1-i,n-1-j)
(n-1-i,n-1-j)->(n-1-j,i)
(n-1-j,i)->(i,j)
*/

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix.length==1) return;
        int n=matrix.length;
        for(int i=0;i<=(n-1)/2;i++){
            for(int j=i;j<n-i-1;j++){
                int tmp=matrix[j][n-1-i];
                matrix[j][n-1-i]=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=tmp;
            }
        }
        
    }
}
