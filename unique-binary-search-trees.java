/*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

/* Solution:
这道题要求可行的二叉查找树的数量，其实二叉查找树可以任意取根，只要满足中序遍历有序的要求就可以。从处理子问题的角度来看，选取一个结点为根，就把结点切成左右子树，以这个结点为根的可行二叉树数量就是左右子树可行二叉树数量的乘积，所以总的数量是将以所有结点为根的可行结果累加起来。写成表达式如下：

熟悉卡特兰数的朋友可能已经发现了，这正是卡特兰数的一种定义方式，是一个典型的动态规划的定义方式（根据其实条件和递推式求解结果）。所以思路也很明确了，维护量res[i]表示含有i个结点的二叉查找树的数量。根据上述递推式依次求出1到n的的结果即可。
时间上每次求解i个结点的二叉查找树数量的需要一个i步的循环，总体要求n次，所以总时间复杂度是O(1+2+...+n)=O(n^2)。空间上需要一个数组来维护，并且需要前i个的所有信息，所以是O(n)。



这道题目要求给定一个数n，有多少种二叉树排列方式，用来存储1到n。

刚开始拿到这题的时候，完全不知道如何下手，但考虑到二叉树的性质，对于任意以i为根节点的二叉树，它的左子树的值一定小于i，也就是[0, i - 1]区间，而右子树的值一定大于i，也就是[i + 1, n]。假设左子树有m种排列方式，而右子树有n种，则对于i为根节点的二叉树总的排列方式就是m x n。

我们使用dp[i]表示i个节点下面二叉树的排列个数，那么dp方程为:

dp[i] = sum(dp[k] * dp[i - k -1]) 
*/
public class Solution {
    public int numTrees(int n) {
        if(n<=0) return 0;
        int[] res=new int[n+1];
        res[0]=1;
        res[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                res[i]+=res[j]*res[i-j-1];
            }
        }
        return res[n];
        
    }
}

//another solution using recursion
int numTrees(int n) 
{
    if(n == 0) return 1;//recursion, maybe, real input 0 shoule return 0
    if(n == 1) return 1;
    int r = 0;
    for(int i = 1; i <= n; i++)
        r += numTrees(i-1)*numTrees(n-i);
    return r;
}
