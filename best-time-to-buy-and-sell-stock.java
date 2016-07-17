/*Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

/* use a variable to store min price
use DP to compute max profit
run time: O(n)*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int min_price=prices[0];
        int max_profit=prices[1]-prices[0];
        for(int i=1;i<prices.length;i++){
            min_price=Math.min(prices[i],min_price);
            max_profit=Math.max(max_profit,prices[i]-min_price);
        }
        if(max_profit<0) return 0;
        return max_profit;
    }
}
