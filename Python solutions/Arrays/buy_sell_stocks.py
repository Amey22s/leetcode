from ast import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        # Initialize max_profit and min_buy
        max_profit = 0
        min_buy = prices[0]

        # Iterate over all nums in list and calculate profit at each step
        # considering sell price as current num and buy price as min_buy.
        # If profit is greater than max_profit update max_profit and if current price
        # is smaller than min_buy update min_buy
        
        for i in prices:
            profit = i - min_buy
            if profit >= max_profit:
                max_profit = profit
            
            if min_buy > i:
                min_buy = i
        
        return max_profit
