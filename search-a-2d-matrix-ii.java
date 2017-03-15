/*Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.

O(m+n) time and O(1) extra space
*/

/*在行和列排序好的二维数组中查找目标数字。这里我们用了一个很巧妙的方法，从矩阵的右上角开始找，相当于把这个元素当作mid，目标比mid大，则row + 1，小则col + 1，相等则返回mid。也是类似二分查找的思想。
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        
        int row=0,col=n-1;
        int count=0;
        
        while(row<m&&col>=0){
            if(matrix[row][col]>target){
                col--;
            }
            else if(matrix[row][col]<target){
                row++;
            }
            else{
                count++;
                row++;
                col--;
            }
        }
        
        return count;
        
    }
}
