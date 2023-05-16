import java.util.*;
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

    // Use a comparator to sort the fist value of each interval in ascending order
    // Use lambda to loop through each current and the next interval and sort them 

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

    // We assign prevEnd as the end of first interval and assign count to 0.

        int prevEnd = intervals[0][1];
        int count = 0;

    // The main idea here is after sorting the intervals on basis of starts, we check if current
    // start is smaller than prevEnd i.e. current interval is overlapping with prev interval,
    // We know there is a overlap so we will need to drop one of the 2. Hence count++.

    // Now on how to decide which interval to drop, we drop the interval whose end is latter
    // among the 2. If there is no overlap, we simply change prevEnd to current end.

        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i][0] < prevEnd)
            {
                count++;
                prevEnd = Math.min(prevEnd,intervals[i][1]);
            }
            else
            {
                prevEnd = intervals[i][1];
            }
        }

    // Finally we return count.

        return count;
    }
}