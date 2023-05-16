import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // First we initialize a arraylist of arrays to store our result.
        // We use arraylist as the size of output is unknown.

        List<int[]> res = new ArrayList<>();

        // The main idea here is to check if newInterval is totally behind current
        // element in intervals, totally after current element in intervals, or overlapping
        // with current element (then we merge).

        for(int i = 0; i < intervals.length; i++)
        {
            // If newInterval is totally after, we add current element to result list.
            if(intervals[i][1] < newInterval[0])
            {
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }

            // If newInterval is totally behind, we first add newInterval to result list.
            // Then we add all the remaining elements from intervals array to the result list
            // and finally return the output after converting list to an array.
            else if(intervals[i][0] > newInterval[1])
            {
                res.add(new int[]{newInterval[0],newInterval[1]});
                while(i < intervals.length)
                {
                    res.add(new int[]{intervals[i][0],intervals[i][1]});
                    i++;
                }
                return getResultArray(res);
            }

            // If newInterval overlaps current element, we don't add anything to result list
            // We just merge the two intervals and continue.
            else
            {
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }

        // If we reach this point this means the latest modified newInterval hasn't been added to
        // the result list yet. So we add it.

        res.add(new int[]{newInterval[0],newInterval[1]});

        // Finally we return the output array after converting current result list to array.

        return getResultArray(res);
        
    }

    // This is a helper function to convert a list of arrays to an array of arrays.

    private int[][] getResultArray(List<int[]> res)
    {
        int[][] arr = new int[res.size()][2];
        int idx = 0;

        for(int[] list : res)
        {
            arr[idx] = list;
            idx++;
        }

        return arr;
    }
}