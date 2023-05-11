from ast import List
class Solution:
    def maxArea(self, height: List[int]) -> int:

        # The idea we use here is to first maximize the length of container.
        # For this we keep 2 pointers one at each end of array for max length.

        left, right = 0, len(height) - 1

        # We also initialize maxArea to negative infi to begin with.
        maxArea = float('-inf')


        # We look for max area till length is not 0 (left and right don't cross).
        while left <= right:
            
            # Calculate area by multiplying length with min of the 2 heights available.
            area = (right - left) * min(height[left],height[right])


            # Update maxArea with maximum of current maxArea and area calculated 
            # in this iteration.

            maxArea = max(maxArea,area)

            # This is where we update the hegiht. Whichever bar is smaller we move that
            # pointer ahead to get a better bar height.

            if height[left] <= height[right]:
                left += 1
            else:
                right -= 1


        # Finally we return maxArea.
        return maxArea