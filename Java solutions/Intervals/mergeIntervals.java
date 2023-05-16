import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {

	// Since we are unsure about the length of the final merged 2D array, we need to initialize a new list

      List<int[]> res = new ArrayList<>();

    // Use a comparator to sort the fist value of each interval in ascending order
    // Use lambda to loop through each current and the next interval and sort them 

      Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

    // Start the strategy be referencing to the first interval
    // Add current interval to result right away

      res.add(new int[]{intervals[0][0], intervals[0][1]});

    // The main idea here is we iterate over all intervals starting from index 1.
    // There are 2 possibilites:
    // 1. The last interval in our result overlaps with current interval in input.
    // 2. They do not overlap.

    // If they do not overlap, we can safely add the current interval to result.
    // Now this interval becomes the last interval in result to be used for comparison next.

    // If they do overlap, we know we have to merge the 2 intervals and we do this by updating
    // end of current last interval in result.

      for(int i = 1; i < intervals.length; i++)
      {
          if(res.get(res.size()-1)[1] < intervals[i][0])
          {
              res.add(new int[]{intervals[i][0], intervals[i][1]});
          }
          else
          {
              res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],intervals[i][1]);
          }
      }

    // Finally convert the result list to an array and return it

      return res.toArray(new int[res.size()][]);
}
}