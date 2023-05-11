class Solution {
    public int maxProfit(int[] prices) {
        

        //Initialize max profit to lowest possible value and minimum buy value to first element of prices array.
        // We do this because for max profit we always check for max between current profit and max profit whereas
        // for minimum buy price there has to be an initial buy price with which we compare upcoming prices and get min.

       int maxProfit = Integer.MIN_VALUE;
       int minBuy = prices[0];

       // Now we iterate over all values of prices array and set our minBuy and maxProfit at each iteration to the same value
       // or a new value based on min and max respectively.
       for(int i = 0; i < prices.length; i++)
       {
           int profit = prices[i] - minBuy;

           maxProfit = Math.max(profit,maxProfit);
           minBuy = Math.min(prices[i],minBuy);
       }

       // We finally return the maxProfit achieved after going through all values.
       return maxProfit;
    }
}