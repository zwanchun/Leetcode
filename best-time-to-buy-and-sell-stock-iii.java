/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

/* http://blog.unieagle.net/2012/12/05/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Abest-time-to-buy-and-sell-stock-iii%EF%BC%8C%E4%B8%80%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
*/

/*runtime: O(N)
space: O(N)
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1) return 0;
        int[] left=new int[prices.length];
        int[] right=new int[prices.length];
        int min_price=prices[0];
        for(int i=1;i<prices.length;i++){
            min_price=Math.min(min_price,prices[i]);
            left[i]=Math.max(left[i-1],prices[i]-min_price);
        }
        int max_price=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            max_price=Math.max(prices[i],max_price);
            right[i]=Math.max(right[i+1],max_price-prices[i]);
        }
        int max_profit=0;
        for(int i=0;i<prices.length;i++){
            max_profit=Math.max(max_profit,left[i]+right[i]);
        }
        return max_profit;
        
    }
}
