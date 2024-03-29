from ast import List
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
    
        # Initialize res, min_prod and max_prod to the first element in list.
        res = min_prod = max_prod = nums[0]
        
        # Iterate over all elements in the list starting from index 1.
        # If current element is negative, our min_product will become max_product and vice versa because of the negative sign.
        # Calculate the new min_prod and max_prod of any subarray till now.
        # Update res if we have a new max subarray product.
        
        for num in nums[1:]:

            if num < 0:
                temp = min_prod
                min_prod = max_prod
                max_prod = temp
                
            min_prod = min(num, min_prod * num)
            max_prod = max(num, max_prod * num)

            res = max(res,max_prod)
        
        return res
        
