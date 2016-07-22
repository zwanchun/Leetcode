/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

/*

http://www.cnblogs.com/springfor/p/3887890.html

考虑2个初始条件，如果矩阵只有一行或者一列，那么无需转圈，依次输出即可。

其他情况均需转圈：从左到右，从上到下，从右到左，从下到上。 从大圈依次循环到小圈即可。
*/



public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res=new ArrayList<Integer>();
        if(matrix==null||matrix.length==0||matrix[0].length==0) return res;
        int m=matrix.length;
        int n=matrix[0].length;
        int index=0;
        for(int i=0;i<=Math.min((n-1)/2,(m-1)/2);i++){
            if(m-2*i==1){
                for(int j=i;j<=n-1-i;j++){
                    res.add(matrix[i][j]);
                }
                break;
            }
            else if(n-2*i==1){
                for(int j=i;j<=m-1-i;j++){
                    res.add(matrix[j][i]);
                }
                break;
            }
            for(int j=i;j<=n-1-i;j++){
                res.add(matrix[i][j]);
            }
            
            for(int j=i+1;j<=m-1-i;j++){
                res.add(matrix[j][n-1-i]);
            }
            for(int j=n-2-i;j>=i;j--){
                res.add(matrix[m-1-i][j]);
            }
            for(int j=m-2-i;j>i;j--){
                res.add(matrix[j][i]);
            }
        }
        return res;
        
    }
}
