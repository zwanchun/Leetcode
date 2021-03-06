/*Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int row=matrix.length;
        int column=matrix[0].length;
        if(target<matrix[0][0]||target>matrix[row-1][column-1]) return false;
        int target_row=0;
        for(int i=0;i<row;i++){
            if(target==matrix[i][0]) return true;
            else if(target<matrix[i][0]){
                target_row=i-1;
                break;
            }
            else if(i==row-1) target_row=i;
        }
        int imin=0,imax=column-1;
        while(imin<=imax){
            int imid=(imax-imin)/2+imin;
            if(matrix[target_row][imid]==target) return true;
            else if(matrix[target_row][imid]<target) imin=imid+1;
            else imax=imid-1;
        }
        return false;
    }
}



public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int m=matrix.length;
        int n=matrix[0].length;
        if(target<matrix[0][0]||target>matrix[m-1][n-1]) return false;
        int i=0;
        for(;i<m;i++){
            if(target>matrix[i][n-1]) continue;
            else break;
            
        }
        
        int left=0, right=n-1;
        while(left+1<right){
            int mid=left+(right-left)/2;
            if(matrix[i][mid]==target) return true;
            else if(matrix[i][left]<target) left=mid;
            else right=mid;
        }
        
        if(matrix[i][left]==target) return true;
        if(matrix[i][right]==target) return true;
        
        return false;
    }
}

