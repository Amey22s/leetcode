from ast import List
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        # We first sort the array so we can use the two pointer approach to our advantage 
        # and also eliminate a few repetitive iterations.

        nums.sort()

        # Initialize list of list of integers to an empty list.

        res = []

        for i in range (len(nums) - 2):

            # As the list is sorted if first element is greater than 0, all succeeding 
            # elements will be greater than 0 so we can stop.

            if nums[i] > 0:
                break

            # This conditional is there to not consider same elements again which 
            # are at a different index.

            if i != 0 and nums[i] == nums[i-1]:
                continue


            # Now for each i we apply two pointer approach, 1 starting from i + 1
            # other from n - 1.

            j = i + 1
            k = len(nums) - 1


            # Iterate over elements till j and k don't cross each other.

            while j < k:

                sum = nums[i] + nums[j] + nums[k]

                # Check is sum is zero, if yes create a temp list of these 3 numbers 
                # and add this temp list to result list.

                if sum == 0:
                    temp = [nums[i],nums[j],nums[k]]
                    res.append(temp)

                    # Move both pointers to next index.

                    j += 1
                    k -= 1

                    # These conditionals are there to not consider same elements again which 
                    # are at a different index.

                    while j < k and nums[j] == nums[j-1]:
                        j += 1
                    while j < k and nums[k] == nums[k+1]:
                        k -= 1
                elif sum > 0:
                
                # If sum is greater than 0 we just move k pointer in as it points to
                # the current highest positive element.
                    k -= 1

                else:

                # If sum is less than 0 we just move j pointer ahead as it points to
                # the current lowest negative element. 
                    j += 1              



        # Finally return the output list.

        return res