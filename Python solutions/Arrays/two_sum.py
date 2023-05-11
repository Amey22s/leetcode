from ast import List
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
    
        #Initialize a map tp store a num and its index as key value pair
        
        map = {}
        idx = 0
        
        
        # Iterate over the all the nums in list and check if its complementary num
        # needed for two sum is present in map. If present return corresponding indexes.
        # Else add the current num and its index in map.
        
        for i in nums:
            key = target - i
            if key in map:
                return (idx,map[key])
            map[i] = idx
            idx += 1
        return (-1, -1)
