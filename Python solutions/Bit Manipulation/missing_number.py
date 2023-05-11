from ast import List
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        #  Initialize res to highest possible element in the nums array given.
        #  In this case it is n (which is nothing but nums.length).
        #  We do this because we are going to iterate over only nums.length - 1
        #  elements in array as anything above that will be index out of bound.

        res = len(nums)

        #  Main idea here is if we XOR an element with itself it gives 0.
        #  So we start with highest element and XOR it with each element in array
        #  and at the same time XOR that result with the index in that iteration.

        #  Effectively, we are performing XOR between all possible elements 0..n
        #  and all given elements in the array. Thus only the missing element will
        #  be present once all others will be present twice reducing everything to
        #  0 XOR missing element. So at the end we have our missing element in res.

        for i in range(len(nums)):
            res = res ^ i ^ nums[i]

        # Finally we return res.

        return res
