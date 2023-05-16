from ast import List
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # Since we are unsure about the length of the final merged 2D array, we need to initialize a new array

        res = []

        # Use a comparator to sort the fist value of each interval in ascending order
        # Use lambda to loop through each current and the next interval and sort them 

        intervals.sort()

        # Start the strategy be referencing to the first interval
        # Add current interval to result right away

        res += [intervals[0]]

        # The main idea here is we iterate over all intervals starting from index 1.
        # There are 2 possibilites:
        # 1. The last interval in our result overlaps with current interval in input.
        # 2. They do not overlap.

        # If they do not overlap, we can safely add the current interval to result.
        # Now this interval becomes the last interval in result to be used for comparison next.

        # If they do overlap, we know we have to merge the 2 intervals and we do this by updating
        # end of current last interval in result.

        for intv in intervals[1:]:
            if res[-1][1] < intv[0]:
                res += [intv]
            else:
                res[-1][1] = max(res[-1][1],intv[1])

        # Finally convert the result list to an array and return it
        return res