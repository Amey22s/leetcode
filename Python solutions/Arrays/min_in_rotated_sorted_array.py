from ast import List
class Solution:
    def findMin(self, nums: List[int]) -> int:

        beg = 0
        end = len(nums) - 1

        #First we check if nums[beg] < nums[end] as this indicates that array is
        # not rotated and in this case we simply return nums[beg].

        # Else in cases where array is rotated we first get mid using 
        # mid = (beg + end) // 2. Then compare nums[beg] and nums[mid].
        # If nums[beg] > nums[mid] the drop must be to the left so end=mid
        # else it will be towards right of mid so beg = mid+1.

        while(beg < end):

            if nums[beg] < nums[end]:
                return nums[beg]

            mid = (beg + end) // 2

            if nums[beg] > nums[mid]:
                end = mid
            else:
                beg = mid + 1

        return nums[beg]
