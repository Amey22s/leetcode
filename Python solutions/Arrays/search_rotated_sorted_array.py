from ast import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:

        beg = 0
        end = len(nums) - 1
        pivot = 0

        # We use the logic from find min in rotated array to find pivot point for rotated array.

        while(beg < end):

            if nums[beg] < nums[end]:
                pivot = beg
                break

            mid = (beg + end) // 2

            if nums[beg] > nums[mid]:
                end = mid
            else:
                beg = mid + 1

        
        pivot = beg

        beg = 0
        end = len(nums) - 1
        n = len(nums)

        # We begin the binary search in the rotated array again, but this time using the pivot to ofset the rotation which allows us to use the usual binary search.
        while(beg <= end):

            mid = (beg + end) // 2

            new_mid = (mid + pivot) % n

            if nums[new_mid] > target:
                end = mid - 1
            elif nums[new_mid] < target:
                beg = mid + 1
            else:
                return new_mid

        return -1
