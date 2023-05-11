from ast import List
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
    
        # Initialize temp_sum, max_sum and all_neg flag
        temp_sum = 0
        max_sum = nums[0]
        all_neg = True


        # Iterate over all nums in list and check if all are negative.
        # If any one element in positive, update all_neg flag to false.
        for i in nums:
            if i > 0:
                all_neg = False
                break
        
        # If all_neg flag is True, just check for highest element in the list and set it to max_sum.
        if all_neg:
            for i in nums:
                max_sum = max(max_sum,i)
            return max_sum
        
        # If all_neg flag is False, iterate over all nums in the list. 
        # Caluclate temp_sum at each step by adding current number to temp_sum till now.
        # If temp_sum till now (local max) is greater than max_sum(gloabal max) update max_sum.
        # If temp_sum becomes negative we need to set it to zero and start a new subarray from next element.
        for i in nums:
            temp_sum += i
            max_sum = temp_sum if temp_sum > max_sum else max_sum
            temp_sum = temp_sum if temp_sum > 0 else 0
        
        return max_sum
