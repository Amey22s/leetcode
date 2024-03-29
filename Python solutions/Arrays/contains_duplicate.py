from ast import List
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        
        # Initialize a dict
        arr = {}

        # Iterate over all nums in the list and check if num is already in dict.
        # If yes return True else add it to dict with its count as 1.
        # If you iterate over all elements without returning true return false.
        
        for i in nums:
            if i in arr:
                return True
            arr[i] = 1  
        
        return False
