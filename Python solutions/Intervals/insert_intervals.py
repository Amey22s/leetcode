from ast import List
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:

        # First we initialize a arraylist of arrays to store our result.
        # We use arraylist as the size of output is unknown.

        res = []

        # The main idea here is to check if newInterval is totally behind current
        # element in intervals, totally after current element in intervals, or overlapping
        # with current element (then we merge).

        for i in range(len(intervals)):

            intv_start = intervals[i][0]
            intv_end = intervals[i][1]

            # If newInterval is totally after, we add current element to result list.

            if intv_end < newInterval[0]:
                res.append([intv_start,intv_end])

            # If newInterval is totally behind, we first add newInterval to result list.
            # Then we add all the remaining elements from intervals array to the result list
            # and finally return the output after converting list to an array.
            elif intv_start > newInterval[1]:
                res.append([newInterval[0],newInterval[1]])
                res += intervals[i:]
                return res

            # If newInterval overlaps current element, we don't add anything to result list
            # We just merge the two intervals and continue.
            else:
                newInterval[0] = min(newInterval[0],intv_start)
                newInterval[1] = max(newInterval[1],intv_end)

        # If we reach this point this means the latest modified newInterval hasn't been added to
        # the result list yet. So we add it.

        res.append([newInterval[0],newInterval[1]])

        # Finally we return the output array after converting current result list to array.

        return res